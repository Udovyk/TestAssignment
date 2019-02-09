package udovyk.testassignment.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class UserResponse implements Parcelable {
	public List<ResultsItem> results;
	public Info info;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeTypedList(this.results);
		dest.writeParcelable(this.info, flags);
	}

	public UserResponse() {
	}

	protected UserResponse(Parcel in) {
		this.results = in.createTypedArrayList(ResultsItem.CREATOR);
		this.info = in.readParcelable(Info.class.getClassLoader());
	}

	public static final Parcelable.Creator<UserResponse> CREATOR = new Parcelable.Creator<UserResponse>() {
		@Override
		public UserResponse createFromParcel(Parcel source) {
			return new UserResponse(source);
		}

		@Override
		public UserResponse[] newArray(int size) {
			return new UserResponse[size];
		}
	};
}