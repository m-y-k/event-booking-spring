package com.example.WebDev;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Event {

    /*
        Object Data Model of an event
        "type:""event""
        uid:18 (user id)
        name: Name of the event
        tagline: A proper tag-line for the event
        schedule: (Date + time) Timestamp
        description: String
        files[image]: Image file (File upload)
        moderator: A user who is going to host
        category: Category of the event
        sub_category: Sub category
        rigor_rank: Integer value
        attendees: Array of user Id's who is attending the event
        "
     */

    private static int instances = 0;
    private int event_id;
    private String type;
    private int uid;
    private String name;
    private String tagline;
    private Timestamp schedule;
    private String description;
    private String moderator; // host
    private String category;
    private String sub_category;
    private int rigor_rank;
    private String files;
    private List<Integer> attendees;


    public Event(String name, String files, String tagline, String description, Timestamp schedule,String moderator, String category, String sub_category, int rigor_rank) {

        this.type = "event";
        this.uid = 18;
        this.event_id = ++instances; // 0 -> 1
        this.name = name;
        this.files = files;
        this.schedule = schedule;
        this.tagline = tagline;
        this.description = description;
        this.moderator = moderator;
        this.category = category;
        this.sub_category = sub_category;
        this.rigor_rank = rigor_rank;
        this.attendees = new ArrayList<>();
    }


    public static int getInstances() {
        return instances;
    }

    public static void setInstances(int instances) {
        Event.instances = instances;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public Timestamp getSchedule() {
        return schedule;
    }

    public void setSchedule(Timestamp schedule) {
        this.schedule = schedule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getModerator() {
        return moderator;
    }

    public void setModerator(String moderator) {
        this.moderator = moderator;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSub_category() {
        return sub_category;
    }

    public void setSub_category(String sub_category) {
        this.sub_category = sub_category;
    }

    public int getRigor_rank() {
        return rigor_rank;
    }

    public void setRigor_rank(int rigor_rank) {
        this.rigor_rank = rigor_rank;
    }

    public List<Integer> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Integer> attendees) {
        this.attendees = attendees;
    }
}
