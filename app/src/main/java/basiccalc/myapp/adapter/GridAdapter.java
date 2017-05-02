package basiccalc.myapp.adapter;

/**
 * Created by Muxammad on 26.04.2017.
 */

import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import basiccalc.myapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ujang Wahyu on 24/01/2017.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    List<EndangeredItem> mItems;

    public GridAdapter() {
        super();

        mItems = new ArrayList<EndangeredItem>();
        EndangeredItem nama = new EndangeredItem();
        nama.setName("Surat Al-Fatihah Ayat 1-7");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Al-Maidah Ayat 1-10");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Al-Baqoroh Ayat 1-10");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Yasin Ayat 1-100");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Al-Maidah Ayat 1-10");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Al-Baqoroh Ayat 1-10");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Yasin Ayat 1-100");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Al-Maidah Ayat 1-10");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Al-Baqoroh Ayat 1-10");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Yasin Ayat 1-100");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Al-Maidah Ayat 1-10");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Al-Baqoroh Ayat 1-10");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Yasin Ayat 1-100");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Al-Maidah Ayat 1-10");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Al-Baqoroh Ayat 1-10");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Yasin Ayat 1-100");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Al-Maidah Ayat 1-10");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Al-Baqoroh Ayat 1-10");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Yasin Ayat 1-100");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Al-Maidah Ayat 1-10");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Al-Baqoroh Ayat 1-10");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Yasin Ayat 1-100");
        nama.setThumbnail(R.drawable.icon);
        mItems.add(nama);


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        EndangeredItem nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {


        public ImageView imgThumbnail;
        public TextView tvspecies;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvspecies = (TextView)itemView.findViewById(R.id.status);

        }
    }
}
