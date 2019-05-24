package com.neobric_assessment_test;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

class UtilClass {

    public static final String responseString = "[{\n" +
            "\t\"lastName\": \"lastName\",\n" +
            "\t\"messageID\": 1000,\n" +
            "\t\"content\": \"Subject : Attach compose test <br/>Attach compose test <attachment:3513:ChatLog Meet Now 2018_04_23 21_21.rtf:application/octet-stream:1555911494716-ChatLog_Meet_Now_2018_04_23_21_21.rtf:388:is_deleted_0:0X0:0X0>\",\n" +
            "\t\"messageType\": \"EMAIL\",\n" +
            "\t\"id\": 1,\n" +
            "\t\"firstName\": \"User\"\n" +
            "},\n" +
            "{\n" +
            "\t\"lastName\": \"lastName2\",\n" +
            "\t\"messageID\": 1001,\n" +
            "\t\"content\": \"Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum\",\n" +
            "\t\"messageType\": \"CHAT\",\n" +
            "\t\"id\": 2,\n" +
            "\t\"firstName\": \"Prasanna test\"\n" +
            "},\n" +
            "{\n" +
            "\t\"lastName\": \"Four\",\n" +
            "\t\"messageID\": 1003,\n" +
            "\t\"content\": \"Subject : Add users \\n <br> <div dir=\\\"ltr\\\"><br clear=\\\"all\\\"><div><div dir=\\\"ltr\\\" class=\\\"gmail_signature\\\" data-smartmail=\\\"gmail_signature\\\"><div dir=\\\"ltr\\\">\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n<p style=\\\"margin:0px;font:12px Menlo;color:rgb(45,100,105);background-color:rgb(255,255,255)\\\"><font face=\\\"comic sans ms, sans-serif\\\" size=\\\"2\\\" color=\\\"#ff9900\\\"><b><i>Thanks,</i></b></font></p><p style=\\\"margin:0px;font:12px Menlo;color:rgb(45,100,105);background-color:rgb(255,255,255)\\\"><font face=\\\"comic sans ms, sans-serif\\\" size=\\\"2\\\" color=\\\"#ff9900\\\"><b><i>Sekhar Kuppa</i></b></font></p><p style=\\\"margin:0px;font:12px Menlo;color:rgb(45,100,105);background-color:rgb(255,255,255)\\\"><font face=\\\"comic sans ms, sans-serif\\\" size=\\\"2\\\" color=\\\"#ff9900\\\"><b><i>Sr. Product Consultant</i></b></font></p><p style=\\\"margin:0px;font:12px Menlo;color:rgb(45,100,105);background-color:rgb(255,255,255)\\\"><font face=\\\"comic sans ms, sans-serif\\\" size=\\\"2\\\" color=\\\"#ff9900\\\"><b><i>91-9704404183</i></b></font></p></div></div></div></div>\\r\\n\",\n" +
            "\t\"messageType\": \"OFFNETEMAIL\",\n" +
            "\t\"id\": 3,\n" +
            "\t\"firstName\": \"Ichigo\"\n" +
            "},\n" +
            "{\n" +
            "\t\"lastName\": \"Singam\",\n" +
            "\t\"messageID\": 1004,\n" +
            "\t\"content\": \"<giphy|https://media3.giphy.com/media/3FQ87l4tXAZWGvV3yY/giphy.gif:480X206:360X155:https://media3.giphy.com/media/3FQ87l4tXAZWGvV3yY/giphy-downsized_s.gif>\",\n" +
            "\t\"messageType\": \"CHATGIPHY\",\n" +
            "\t\"id\": 4,\n" +
            "\t\"firstName\": \"Four\"\n" +
            "},\n" +
            "{\n" +
            "\t\"lastName\": \"Singam\",\n" +
            "\t\"messageID\": 1005,\n" +
            "\t\"content\": \":battery::tractor::sweat_smile::helicopter::cricket_game:\",\n" +
            "\t\"messageType\": \"CHATEMOJI\",\n" +
            "\t\"id\": 5,\n" +
            "\t\"firstName\": \"Five\"\n" +
            "}]";

    public static void ShowToastMessage(Context context, String message) {
        if (context != null) {
            Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

}
