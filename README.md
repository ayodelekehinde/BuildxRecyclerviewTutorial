# BuildxRecyclerviewTutorial
Learn how to implement RecyclerView on Buildx

To implement RecyclerView
* Step1: add recyclerview to your xml view
```Xml
   <androidx.recyclerview.widget.RecyclerView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/my_list">

    </androidx.recyclerview.widget.RecyclerView>

```
* Step 2: Create your item view.

* Step 3: Create a model class for your data
  model class is a class that defines the kind of item you wanna display on recyclerView
  E.g 
  ```Java
  For example if im displaying a list of countries it will have names, flag, continent i will 
     have a model class like
     public class Country {
       private String countryName;
       private String countryFlagUrl;
       private String continent; 

       /* This is a constructor with parameters, meaning if you do
       Country country = Country("England","flagurl", "Europe");
       countryName will now be England, so when you call country.getCountryName(); youll get England as response
        */

       public Country(String countryName, String countryFlagUrl, String continent){
       this.countryName = countryName;
       this.countryFlagUrl = countryFlagUrl;
       this.continent = continent;
       } 

        public String getCountryName(){
        return countryName;
       }
       public String getCountryFlagUrl(){
        return countryFlagUrl;
       }
       public String getContinent(){
        return continenrt;
       }
     }
  ```

  * Step 4: Create your Adapter class
  ```Java
  public class CountryAdapter extends  RecyclerView.Adapter<CountryAdapter.CountryViewHolder> { 

    /* List<> is a collection class like Map or HashMap, its very cool.
     List<> can use any class eg List<View> 
     Country is our model class that we created, it simply means This adapter will display 
     a list of items of TYPE Country 
     */

    private List<Country> countries = new ArrayList<>(); 

    // Context is needed in some part of the adapter	
    private Context mContext;

    /* Again this a constructor, it is used to pass objects from other class
     here we are passing Context and our List<Country>, but since they
     can't be assessed through out the adapter we setting them to our already
     declared Context and List<Country>
     */

    public CountryAdapter(Context context, List<Country> countries){
      this.countries = countries;
      this.mContext = context;

    }

    /* addNewItem method is used like the constructor but constructor are initiated 
       on declaration 
       notifyDataSetChanged(); is a method called to tell the adapter that new list is added*/

    public void addNewItem(List<Country> countries){
        this.countries = countries;
        notifyDataSetChanged();
    }


    /* Oncreateviewholder will draw your item view its an overriden from the RecyclerView.Adapter
      inflating your item view */
    @NonNull
    @Override
    public ViewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.country_items, parent,false);
        return new ViewsViewHolder(v);
    }

    /* onbindviewholder is where you bind your data to the item view. meaning getting values from the
     List<Country> item to set to the view
     textViews or imageView etc 
     CountryViewHolder is where you instantiate your views, its a class that extends RecyclerView.ViewHolder
     the class is implemented below 
     while int position is the current item to bind to view*/

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        final Country country = countries.get(position);
        //bindView is a method inside CountryViewHolder

        holder.bindView(country.getCountryName(),country.getCountryFlagUrl(),country.getContinent());

        //Setting click listener on item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, YourActivity.class);
                mContext.startActivity(i);
            }
        });

        

    }

    /* this method is very important in adapter class
     it returns total no of items in your List<Country>
      ... */  
    @Override
    public int getItemCount() {
        return countries.size();
    }

    /* The viewholder for your view item in your layout, they serve as 
    how the items inside the recyclerView will look like 
    it is a class that extends RecyclerView.ViewHolder 
    Note: it must have a constructor
    if you wanna manipulate anything in your item, heres where youll do it*/

    class CountryViewHolder extends RecyclerView.ViewHolder{
    	//views inside your country_item
        TextView countryName, continent;

        //Constructor: very important with the super() method
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            //notice we did itemView.findView... because any view here is a child of itemView
            countryName = itemView.findViewById(R.id.country_item);
            continent = itemView.findViewById(R.id.continent);

        }

        // the method i called in onBindView setting data to items
         void bindView(String countryName, String continent){
            countryName.setText(name);
            continent.setText(size);
        }
    }
}

