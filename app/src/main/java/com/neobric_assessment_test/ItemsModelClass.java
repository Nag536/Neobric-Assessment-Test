package com.neobric_assessment_test;

class ItemsModelClass {
    private final String firstName;
    private final String lastName;
    private final String content;
    private final String messageType;
    private final int messageID;
    private final int id;

    public ItemsModelClass(String firstName, String lastName, String content, String messageType, int messageID, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.content = content;
        this.messageType = messageType;
        this.messageID = messageID;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContent() {
        return content;
    }

    public String getMessageType() {
        return messageType;
    }

    public int getMessageID() {
        return messageID;
    }

    public int getId() {
        return id;
    }
}
