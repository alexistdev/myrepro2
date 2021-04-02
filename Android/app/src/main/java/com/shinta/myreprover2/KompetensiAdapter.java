package com.shinta.myreprover2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class KompetensiAdapter extends ArrayAdapter<Kompetensi> {
    private Context mContext;
    private List<Kompetensi> daftarKompetensi = new ArrayList<>();

    KompetensiAdapter(@NonNull Context context, ArrayList<Kompetensi> list){
        super(context,0,list);
        mContext = context;
        daftarKompetensi = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        try{
            if (listItem == null)
                listItem = LayoutInflater.from(mContext).inflate(R.layout.customlayout, parent, false);

            Kompetensi pilihan = daftarKompetensi.get(position);

            ImageView image = (ImageView) listItem.findViewById(R.id.menutentang);
            image.setImageResource(pilihan.getmImgGambar());

//        TextView name = (TextView) listItem.findViewById(R.id.tvTulisanku);
//        name.setText(currentMovie.getnName());
        }
            catch (Exception e){
                Toast.makeText(mContext.getApplicationContext(), "Error",Toast.LENGTH_LONG).show();
        }
        return listItem;
    }
}
