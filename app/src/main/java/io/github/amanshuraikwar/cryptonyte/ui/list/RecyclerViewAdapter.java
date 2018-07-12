package io.github.amanshuraikwar.cryptonyte.ui.list;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView adapter which supports different type of ViewHolders efficiently.
 * Uses visitable design pattern.
 *
 * @author Amanshu Raikwar
 * Created by sonu on 30/6/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    /**
     * List of ListItems displayed in the list.
     */
    private List<ListItem> listItems;

    /**
     * List item type factory.
     */
    private ListItemTypeFactory typeFactory;

    /**
     * Reference to the parent activity.
     */
    private FragmentActivity parentActivity;

    /**
     * Constructor with initial list items.
     *
     * @param activity parent activity.
     * @param typeFactory list item type factory.
     * @param listItems initial list of list items.
     */
    public RecyclerViewAdapter(@NonNull FragmentActivity activity,
                               @NonNull ListItemTypeFactory typeFactory,
                               @NonNull List<ListItem> listItems) {
        this.typeFactory = typeFactory;
        this.parentActivity = activity;
        this.listItems = listItems;
    }

    /**
     * Constructor with empty initial list of list items.
     *
     * @param parentActivity parent activity.
     * @param typeFactory list item type factory.
     */
    public RecyclerViewAdapter(@NonNull FragmentActivity parentActivity,
                               @NonNull ListItemTypeFactory typeFactory) {
        this.typeFactory = typeFactory;
        this.parentActivity = parentActivity;
        listItems = new ArrayList<>();
    }

    //region overrided methods
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View contactView =
                LayoutInflater
                        .from(parentActivity)
                        .inflate(typeFactory.getLayout(viewType), parent, false);

        return typeFactory.createViewHolder(contactView, viewType);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bind(listItems.get(position), parentActivity);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return listItems.get(position).type(typeFactory);
    }
    //endregion

    /**
     * To determine is the list is empty or not.
     *
     * @return boolean telling the same.
     */
    public boolean isEmpty() {
        return listItems.size() == 0;
    }

    /**
     * To get the parent activity.
     *
     * @return FragmentActivity instance of the parent activity.
     */
    protected FragmentActivity getActivity() {
        return parentActivity;
    }

    /**
     * To get all the list items.
     *
     * @return list of list items.
     */
    public List<ListItem> getListItems() {
        return listItems;
    }

    /**
     * To get list item at an index.
     *
     * @param index index of the required list item.
     * @return ListItem corresponding for the given index.
     */
    public ListItem getListItem(int index) {
        return listItems.get(index);
    }

    /**
     * To replace the list of list items with the given list.
     *
     * @param listItems list of list items.
     */
    public void replaceListItems(List<ListItem> listItems) {
        this.listItems = listItems;
    }

    /**
     * To add the given list of list items at the end of current list of list items.
     *
     * @param newListItems new list of ListItem to be added.
     */
    public void addListItems(List<ListItem> newListItems) {
        listItems.addAll(newListItems);
    }

    /**
     * To add a list item as the end of the current list.
     *
     * @param newListItem new ListItem to be added.
     */
    public void addListItem(ListItem newListItem) {
        listItems.add(newListItem);
    }

    /**
     * To add a list of list items in between at a given index.
     * Pushes the elements below down.
     *
     * @param index index where the new list of list items is to be added.
     * @param newListItems new list of list items that is to be added.
     */
    public void addListItems(int index, List<ListItem> newListItems) {
        listItems.addAll(index, newListItems);
    }

    /**
     * To add a list item in between at a given index.
     * Pushes the elements below down.
     *
     * @param index index where the new list item is to be added.
     * @param newListItem new list item that is to be added.
     */
    public void addListItem(int index, ListItem newListItem) {
        listItems.add(index, newListItem);
    }

    /**
     * To remove a list item at a given index.
     * @param index index of which the list item is to be removed.
     */
    public void removeListItem(int index) {
        listItems.remove(index);
    }

    /**
     * To clear the list empty.
     */
    public void clearList() {
        listItems = new ArrayList<>();
    }
}
