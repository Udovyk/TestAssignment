package udovyk.testassignment.network.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Name implements Parcelable {
	public String last;
	public String title;
	public String first;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.last);
		dest.writeString(this.title);
		dest.writeString(this.first);
	}

	public Name() {
	}

	protected Name(Parcel in) {
		this.last = in.readString();
		this.title = in.readString();
		this.first = in.readString();
	}

	public static final Parcelable.Creator<Name> CREATOR = new Parcelable.Creator<Name>() {
		@Override
		public Name createFromParcel(Parcel source) {
			return new Name(source);
		}

		@Override
		public Name[] newArray(int size) {
			return new Name[size];
		}
	};
}
