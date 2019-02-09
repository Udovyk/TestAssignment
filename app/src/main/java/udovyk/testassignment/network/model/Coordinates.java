package udovyk.testassignment.network.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Coordinates implements Parcelable {
	public String latitude;
	public String longitude;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.latitude);
		dest.writeString(this.longitude);
	}

	public Coordinates() {
	}

	protected Coordinates(Parcel in) {
		this.latitude = in.readString();
		this.longitude = in.readString();
	}

	public static final Parcelable.Creator<Coordinates> CREATOR = new Parcelable.Creator<Coordinates>() {
		@Override
		public Coordinates createFromParcel(Parcel source) {
			return new Coordinates(source);
		}

		@Override
		public Coordinates[] newArray(int size) {
			return new Coordinates[size];
		}
	};
}
