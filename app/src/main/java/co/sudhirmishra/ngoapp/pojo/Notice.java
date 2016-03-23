package co.sudhirmishra.ngoapp.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FDUSER on 26-Feb-16.
 */
public class Notice implements Parcelable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("body")
    @Expose
    public String body;
    @SerializedName("category")
    @Expose
    public List<Category> category = new ArrayList<Category>();
    @SerializedName("registration")
    @Expose
    public Boolean registration;
    @SerializedName("event_date")
    @Expose
    public String eventDate;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("contact")
    @Expose
    public List<Contact> contact = new ArrayList<Contact>();
    @SerializedName("venue")
    @Expose
    public String venue;
    @SerializedName("deadline")
    @Expose
    public String deadline;


    protected Notice(Parcel in) {
        id = in.readByte() == 0x00 ? null : in.readInt();
        title = in.readString();
        body = in.readString();
        if (in.readByte() == 0x01) {
            category = new ArrayList<Category>();
            in.readList(category, Category.class.getClassLoader());
        } else {
            category = null;
        }
        byte registrationVal = in.readByte();
        registration = registrationVal == 0x02 ? null : registrationVal != 0x00;
        eventDate = in.readString();
        image = in.readString();
        if (in.readByte() == 0x01) {
            contact = new ArrayList<Contact>();
            in.readList(contact, Contact.class.getClassLoader());
        } else {
            contact = null;
        }
        venue = in.readString();
        deadline = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(id);
        }
        dest.writeString(title);
        dest.writeString(body);
        if (category == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(category);
        }
        if (registration == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (registration ? 0x01 : 0x00));
        }
        dest.writeString(eventDate);
        dest.writeString(image);
        if (contact == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(contact);
        }
        dest.writeString(venue);
        dest.writeString(deadline);
    }

    @SuppressWarnings("unused")
    public static final Creator<Notice> CREATOR = new Creator<Notice>() {
        @Override
        public Notice createFromParcel(Parcel in) {
            return new Notice(in);
        }

        @Override
        public Notice[] newArray(int size) {
            return new Notice[size];
        }
    };
}
