package com.jiading.classes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Stream {
    public String getStreamName() {
        return streamName.get();
    }

    public StringProperty streamNameProperty() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName.set(streamName);
    }

    public String getStreamURL() {
        return streamURL.get();
    }

    public StringProperty streamURLProperty() {
        return streamURL;
    }

    public void setStreamURL(String streamURL) {
        this.streamURL.set(streamURL);
    }

    private final StringProperty streamName;
    private final StringProperty streamURL;
    public Stream(String streamName,String streamURL){
        this.streamName=new SimpleStringProperty(streamName);
        this.streamURL=new SimpleStringProperty(streamURL);
    }
}
