package udovyk.testassignment.network.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Login implements Parcelable {
	public String sha1;
	public String password;
	public String salt;
	public String sha256;
	public String uuid;
	public String username;
	public String md5;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.sha1);
		dest.writeString(this.password);
		dest.writeString(this.salt);
		dest.writeString(this.sha256);
		dest.writeString(this.uuid);
		dest.writeString(this.username);
		dest.writeString(this.md5);
	}

	public Login() {
	}

	protected Login(Parcel in) {
		this.sha1 = in.readString();
		this.password = in.readString();
		this.salt = in.readString();
		this.sha256 = in.readString();
		this.uuid = in.readString();
		this.username = in.readString();
		this.md5 = in.readString();
	}

	public static final Parcelable.Creator<Login> CREATOR = new Parcelable.Creator<Login>() {
		@Override
		public Login createFromParcel(Parcel source) {
			return new Login(source);
		}

		@Override
		public Login[] newArray(int size) {
			return new Login[size];
		}
	};
}
