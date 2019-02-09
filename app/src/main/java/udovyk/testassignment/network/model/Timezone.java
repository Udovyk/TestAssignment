package udovyk.testassignment.network.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Timezone implements Parcelable {
	public String offset;
	public String description;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.offset);
		dest.writeString(this.description);
	}

	public Timezone() {
	}

	protected Timezone(Parcel in) {
		this.offset = in.readString();
		this.description = in.readString();
	}

	public static final Parcelable.Creator<Timezone> CREATOR = new Parcelable.Creator<Timezone>() {
		@Override
		public Timezone createFromParcel(Parcel source) {
			return new Timezone(source);
		}

		@Override
		public Timezone[] newArray(int size) {
			return new Timezone[size];
		}
	};
}
