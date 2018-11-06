package post.com.boxes.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public class BaseBox implements Parcelable {
    protected String name;
    protected double length;
    protected double width;
    protected double height;
    protected int price;

    public BaseBox() {
    }

    protected BaseBox(Parcel in) {
        name = in.readString();
        length = in.readDouble();
        width = in.readDouble();
        height = in.readDouble();
        price = in.readInt();
    }

    public static final Creator<BaseBox> CREATOR = new Creator<BaseBox>() {
        @Override
        public BaseBox createFromParcel(Parcel in) {
            return new BaseBox(in);
        }

        @Override
        public BaseBox[] newArray(int size) {
            return new BaseBox[size];
        }
    };

    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public int getPrice() {
        return price;
    }

    public boolean check(double length, double width, double height) {
        if (length <= this.length && width <= this.width && height <= this.height)
            return true;
        return false;
    }

    @NonNull
    @Override
    public String toString() {
        return length + "/" + width + "/" + height + "cm";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeDouble(length);
        parcel.writeDouble(width);
        parcel.writeDouble(height);
        parcel.writeInt(price);
    }
}
