package udovyk.testassignment.network.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Info implements Parcelable {
	public String seed;
	public int page;
	public int results;
	public String version;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.seed);
		dest.writeInt(this.page);
		dest.writeInt(this.results);
		dest.writeString(this.version);
	}

	public Info() {
	}

	protected Info(Parcel in) {
		this.seed = in.readString();
		this.page = in.readInt();
		this.results = in.readInt();
		this.version = in.readString();
	}

	public static final Parcelable.Creator<Info> CREATOR = new Parcelable.Creator<Info>() {
		@Override
		public Info createFromParcel(Parcel source) {
			return new Info(source);
		}

		@Override
		public Info[] newArray(int size) {
			return new Info[size];
		}
	};
}
