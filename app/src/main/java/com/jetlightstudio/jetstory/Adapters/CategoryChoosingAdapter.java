package com.jetlightstudio.jetstory.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jetlightstudio.jetstory.R;
import com.jetlightstudio.jetstory.ToolBox.App;
import com.jetlightstudio.jetstory.ToolBox.FontAwesome;
import com.jetlightstudio.jetstory.ToolBox.HelpFullFunctions;

import java.util.ArrayList;
import java.util.Arrays;

public class CategoryChoosingAdapter extends RecyclerView.Adapter<CategoryChoosingAdapter.ViewHolder> {
    ArrayList<String> categories;
    ArrayList<Boolean> selectedCategories;

    public CategoryChoosingAdapter() {
        this.categories = new ArrayList<>();
        selectedCategories = new ArrayList<>();
        categories.addAll(Arrays.asList("Action", "Romance", "Adventure", "Classics", "Comedy", "Kids", "Thriller", "Historic", "Science fiction"));
        for (int i = 0; i < categories.size(); i++) {
            selectedCategories.add(false);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        FontAwesome categoryLabel;
        LinearLayout layoutBackground;

        ViewHolder(View itemView) {
            super(itemView);
            categoryLabel = itemView.findViewById(R.id.categoryLabel);
            layoutBackground = itemView.findViewById(R.id.layoutBackground);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            String text = !selectedCategories.get(getAdapterPosition()) ?
                    categories.get(getAdapterPosition()) + " " + App.getContext().getResources().getString(R.string.icon_checked)
                    : categories.get(getAdapterPosition()) + " " + App.getContext().getResources().getString(R.string.icon_plus);
            categoryLabel.setText(text);
            HelpFullFunctions.setViewColor(layoutBackground, !selectedCategories.get(getAdapterPosition()) ? "#9AD945" : "#FE9025");
            layoutBackground.setElevation(!selectedCategories.get(getAdapterPosition()) ? 15 : 2);
            selectedCategories.set(getAdapterPosition(), !selectedCategories.get(getAdapterPosition()));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) App.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_cetegory_adapter, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String text = selectedCategories.get(position) ?
                categories.get(position) + " " + App.getContext().getResources().getString(R.string.icon_checked)
                : categories.get(position) + " " + App.getContext().getResources().getString(R.string.icon_plus);
        holder.categoryLabel.setText(text);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public ArrayList<String> getCategories() {
        ArrayList<String> selectedCategoriesNames = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            if (selectedCategories.get(i))
                selectedCategoriesNames.add(categories.get(i).toLowerCase());
        }
        return selectedCategoriesNames;
    }

    public ArrayList<String> getUnfilteredCategories() {
        return categories;
    }
}