package udovyk.testassignment.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ResultsItem implements Parcelable {
	public String nat;
	public String gender;
	public String phone;
	public Dob dob;
	public Name name;
	public Registered registered;
	public Location location;
	public Id id;
	public Login login;
	public String cell;
	public String email;
	public Picture picture;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.nat);
		dest.writeString(this.gender);
		dest.writeString(this.phone);
		dest.writeParcelable(this.dob, flags);
		dest.writeParcelable(this.name, flags);
		dest.writeParcelable(this.registered, flags);
		dest.writeParcelable(this.location, flags);
		dest.writeParcelable(this.id, flags);
		dest.writeParcelable(this.login, flags);
		dest.writeString(this.cell);
		dest.writeString(this.email);
		dest.writeParcelable(this.picture, flags);
	}

	public ResultsItem() {
	}

	protected ResultsItem(Parcel in) {
		this.nat = in.readString();
		this.gender = in.readString();
		this.phone = in.readString();
		this.dob = in.readParcelable(Dob.class.getClassLoader());
		this.name = in.readParcelable(Name.class.getClassLoader());
		this.registered = in.readParcelable(Registered.class.getClassLoader());
		this.location = in.readParcelable(Location.class.getClassLoader());
		this.id = in.readParcelable(Id.class.getClassLoader());
		this.login = in.readParcelable(Login.class.getClassLoader());
		this.cell = in.readString();
		this.email = in.readString();
		this.picture = in.readParcelable(Picture.class.getClassLoader());
	}

	public static final Parcelable.Creator<ResultsItem> CREATOR = new Parcelable.Creator<ResultsItem>() {
		@Override
		public ResultsItem createFromParcel(Parcel source) {
			return new ResultsItem(source);
		}

		@Override
		public ResultsItem[] newArray(int size) {
			return new ResultsItem[size];
		}
	};
}
