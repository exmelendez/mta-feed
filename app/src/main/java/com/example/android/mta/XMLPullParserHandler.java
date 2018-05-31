package com.example.android.mta;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLPullParserHandler {

    List<LineStatus> lineStatuses;
    private LineStatus lineStatus;

    private String text;

    public XMLPullParserHandler() {
        lineStatuses = new ArrayList<>();
    }

    public List<LineStatus> parse(InputStream is) {
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;

        try {

            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);

            parser = factory.newPullParser();
            parser.setInput(is, null);

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();

                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("line")) {
                            lineStatus = new LineStatus();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("line")) {
                            lineStatuses.add(lineStatus);
                        } else if (tagname.equalsIgnoreCase("name")) {
                            lineStatus.setLine(text);
                        } else if (tagname.equalsIgnoreCase("status")) {
                            lineStatus.setStatus(text);
                        } else if (tagname.equalsIgnoreCase("Date")) {
                            lineStatus.setDate(text);
                        }
                        break;

                    default:
                        break;
                }

                eventType = parser.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lineStatuses;
    }

}