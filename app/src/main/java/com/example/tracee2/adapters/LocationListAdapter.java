package com.example.tracee2.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tracee2.R;
import com.example.tracee2.models.Business;
import com.example.tracee2.ui.LocationDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LocationListAdapter extends RecyclerView.Adapter<LocationListAdapter.LocationViewHolder> {
    private List<Business> mLocation;
    private Context mContext;

    public LocationListAdapter(Context context, List<Business> location) {
        mContext = context;
        mLocation = location;
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_item, parent, false);
        LocationViewHolder viewHolder = new LocationViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {
        holder.bindRestaurant(mLocation.get(position));
    }

    @Override
    public int getItemCount() {
        return mLocation.size();
    }

    public class LocationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.locationImageView) ImageView mLocationImageView;
        @BindView(R.id.locationNameTextView) TextView mNameTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;
        private Context mContext;

        public LocationViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindRestaurant(Business trails) {
            mNameTextView.setText(trails.getName());
            mCategoryTextView.setText(trails.getCategories().get(0).getTitle());
            mRatingTextView.setText("Rating: " + trails.getRating() + "/5");
            Picasso.get().load(trails.getImageUrl()).into(mLocationImageView);
        }
        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, LocationDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("location", Parcels.wrap(mLocation));
            mContext.startActivity(intent);
        }
    }
}