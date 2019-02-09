package udovyk.testassignment.network.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {
	public String city;
	public String street;
	public Timezone timezone;
	public String postcode;
	public Coordinates coordinates;
	public String state;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.city);
		dest.writeString(this.street);
		dest.writeParcelable(this.timezone, flags);
		dest.writeString(this.postcode);
		dest.writeParcelable(this.coordinates, flags);
		dest.writeString(this.state);
	}

	public Location() {
	}

	protected Location(Parcel in) {
		this.city = in.readString();
		this.street = in.readString();
		this.timezone = in.readParcelable(Timezone.class.getClassLoader());
		this.postcode = in.readString();
		this.coordinates = in.readParcelable(Coordinates.class.getClassLoader());
		this.state = in.readString();
	}

	public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
		@Override
		public Location createFromParcel(Parcel source) {
			return new Location(source);
		}

		@Override
		public Location[] newArray(int size) {
			return new Location[size];
		}
	};
}
