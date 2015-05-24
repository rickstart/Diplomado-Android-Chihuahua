package com.mobintum.movierank.fragments;

import android.app.Activity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.mobintum.movierank.R;
import com.mobintum.movierank.adapters.MovieAdapter;
import com.mobintum.movierank.models.Movie;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ListMoviesFragment extends Fragment {

    private static final String API_KEY = "35hg37n2zaybbwf7wncj9vgw";
    private final String URL = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=";
    private final String QUERY = "love";
    private MovieAdapter adapter;
    private Context context;
    private ListView listMovies;
    private Menu menu;
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    private OnFragmentInteractionListener mListener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getActivity();
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_movies, container, false);
        setRefreshActionButtonState(false);
        listMovies = (ListView) view.findViewById(R.id.listMovies);
        adapter = new MovieAdapter(context,R.layout.item_list_movie,movies);
        listMovies.setAdapter(adapter);
        listMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onMovieSelected(movies.get(position));
            }
        });
        return view;
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        public void onMovieSelected(Movie movie);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        this.menu = menu;
        menu.clear();
        inflater.inflate(R.menu.menu_movie_search, menu);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.menuSearch).getActionView();
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(getActivity().getComponentName());
        searchView.setSearchableInfo(searchableInfo);

        searchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                String querywoSpace = query.trim().replaceAll(" +", "%20");
                Log.e("QUERY", querywoSpace);
                new RottenRequest().execute(URL+API_KEY+"&q="+querywoSpace);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(!newText.equals("")) {
                    String querywoSpace = newText.trim().replaceAll(" +", "%20");
                    Log.e("QUERY", querywoSpace);

                    new RottenRequest().execute(URL + API_KEY + "&q=" + querywoSpace);
                }
                return false;
            }
        });

    }

    public void setRefreshActionButtonState(boolean refresh){
        if(menu!=null){
            MenuItem refreshItem = menu.findItem(R.id.menuRefresh);
            if(refreshItem!=null){
                if(refresh){
                    refreshItem.setVisible(true);
                    refreshItem.setActionView(R.layout.progress);
                }else{
                    refreshItem.setVisible(false);
                }
            }
        }
    }

    public class RottenRequest extends AsyncTask<String,Void,String>{




        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setRefreshActionButtonState(true);
        }

        @Override
        protected String doInBackground(String... params) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpResponse httpResponse;
            String response;

            try{
                httpResponse = httpClient.execute(new HttpGet(params[0]));
                StatusLine statusLine = httpResponse.getStatusLine();
                if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    httpResponse.getEntity().writeTo(out);
                    out.close();
                    response = out.toString();
                    return response;
                }else{
                    return null;
                }
            }catch(Exception e){

                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            setRefreshActionButtonState(false);
            if(response!=null){
                Log.e("JSON", response);

                movies = Movie.parseJson(response);
                adapter.clear();
                adapter.addAll(movies);
                adapter.notifyDataSetChanged();
            }

        }

    }


}
