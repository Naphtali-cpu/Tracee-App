package com.example.tracee2.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tracee2.R;
import com.example.tracee2.models.Business;
import com.example.tracee2.models.Category;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocationDetailFragment extends Fragment {
    @BindView(R.id.restaurantImageView) ImageView mImageLabel;
    @BindView(R.id.restaurantNameTextView) TextView mNameLabel;
    @BindView(R.id.cuisineTextView) TextView mCategoriesLabel;
    @BindView(R.id.ratingTextView) TextView mRatingLabel;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
    @BindView(R.id.phoneTextView) TextView mPhoneLabel;
    @BindView(R.id.addressTextView) TextView mAddressLabel;
    @BindView(R.id.saveRestaurantButton) TextView mSaveRestaurantButton;


    private Business mLocation;

    public LocationDetailFragment() {
        // Required empty public constructor
    }


    public static LocationDetailFragment newInstance(Business location) {
        LocationDetailFragment restaurantDetailFragment = new LocationDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("trails", Parcels.wrap(location));
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mLocation = Parcels.unwrap(getArguments().getParcelable("trails"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_location_detail, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(mLocation.getImageUrl()).into(mImageLabel);

        List<String> categories = new ArrayList<>();

        for (Category category: mLocation.getCategories()) {
            categories.add(category.getTitle());
        }

        mNameLabel.setText(mLocation.getName());
        mCategoriesLabel.setText(android.text.TextUtils.join(", ", categories));
        mRatingLabel.setText(Double.toString(mLocation.getRating()) + "/5");
        mPhoneLabel.setText(mLocation.getPhone());
        mAddressLabel.setText(mLocation.getLocation().toString());

        return view;
    }
}