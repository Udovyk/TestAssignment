package udovyk.testassignment.network.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Id implements Parcelable {
	public String name;
	public String value;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.name);
		dest.writeString(this.value);
	}

	public Id() {
	}

	protected Id(Parcel in) {
		this.name = in.readString();
		this.value = in.readString();
	}

	public static final Parcelable.Creator<Id> CREATOR = new Parcelable.Creator<Id>() {
		@Override
		public Id createFromParcel(Parcel source) {
			return new Id(source);
		}

		@Override
		public Id[] newArray(int size) {
			return new Id[size];
		}
	};
}
