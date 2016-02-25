package com.li8tech.nli8.prototype.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by FDUSER on 26-Feb-16.
 */
public class Contact implements Parcelable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("password")
    @Expose
    public String password;
    @SerializedName("last_login")
    @Expose
    public String lastLogin;
    @SerializedName("is_superuser")
    @Expose
    public Boolean isSuperuser;
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("first_name")
    @Expose
    public String firstName;
    @SerializedName("last_name")
    @Expose
    public String lastName;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("is_staff")
    @Expose
    public Boolean isStaff;
    @SerializedName("is_active")
    @Expose
    public Boolean isActive;
    @SerializedName("date_joined")
    @Expose
    public String dateJoined;
/*@SerializedName("groups")
@Expose
public List<Object> groups = new ArrayList<Object>();
@SerializedName("user_permissions")
@Expose
public List<Object> userPermissions = new ArrayList<Object>();*/


    protected Contact(Parcel in) {
        id = in.readByte() == 0x00 ? null : in.readInt();
        password = in.readString();
        lastLogin = in.readString();
        byte isSuperuserVal = in.readByte();
        isSuperuser = isSuperuserVal == 0x02 ? null : isSuperuserVal != 0x00;
        username = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        email = in.readString();
        byte isStaffVal = in.readByte();
        isStaff = isStaffVal == 0x02 ? null : isStaffVal != 0x00;
        byte isActiveVal = in.readByte();
        isActive = isActiveVal == 0x02 ? null : isActiveVal != 0x00;
        dateJoined = in.readString();
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
        dest.writeString(password);
        dest.writeString(lastLogin);
        if (isSuperuser == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (isSuperuser ? 0x01 : 0x00));
        }
        dest.writeString(username);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(email);
        if (isStaff == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (isStaff ? 0x01 : 0x00));
        }
        if (isActive == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (isActive ? 0x01 : 0x00));
        }
        dest.writeString(dateJoined);
    }

    @SuppressWarnings("unused")
    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}
