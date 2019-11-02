package com.example.yisela.mibusnavidrawer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class ConfirmarActivity extends AppCompatActivity implements OnMapReadyCallback
{
    private GoogleMap mMap;
    Polyline unosotracauca;
    Polyline dostranslibertad;
    Polyline trestranstambo;
    Polyline cuatrotranstimbio;
    Polyline cincosotracauca;
    Polyline seistranslibertad;
    Polyline sietetranstambo;
    public LatLng direccionorigenfinal;
    public LatLng direcciondestinofinal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        Bundle extras = getIntent().getExtras();
        LatLng objLatLngorigen = extras.getParcelable("Latlngorigen");
        LatLng objLatLngdestino = extras.getParcelable("Latlngdestino");
        direccionorigenfinal = objLatLngorigen;
        direcciondestinofinal = objLatLngdestino;
        Marker a = mMap.addMarker(new MarkerOptions().position(objLatLngorigen).title("Origen"));
        a.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pegmancuatro));
        mMap.addMarker(new MarkerOptions().position(objLatLngdestino).title("Destino"));

        try
        {
//            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(objLatLngorigen, objLatLngdestino), 320));
        }catch (Exception e)
        {
//            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(objLatLngdestino, objLatLngorigen), 320));
        }

        unosotracauca = mMap.addPolyline(new PolylineOptions()
                .visible(false)
                .add(new LatLng(2.455519, -76.597619), new LatLng(2.448227, -76.612986)
                        , new LatLng(2.447169, -76.613998), new LatLng(2.444761, -76.614903)
                        , new LatLng(2.433474, -76.617058))
                .width(10)
                .color(Color.RED));
        dostranslibertad = mMap.addPolyline(new PolylineOptions()
                .visible(false)
                .add(new LatLng(2.455519, -76.597619), new LatLng(2.451851, -76.605270)
                        , new LatLng(2.446088, -76.607306), new LatLng(2.446340, -76.609124)
                        , new LatLng(2.445770, -76.614557), new LatLng(2.433118, -76.617210))
                .width(10)
                .color(Color.BLUE));
        trestranstambo = mMap.addPolyline(new PolylineOptions()
                .visible(false)
                .add(new LatLng(2.455519, -76.597619), new LatLng(2.451953, -76.605416)
                        , new LatLng(2.448007, -76.613413), new LatLng(2.447285, -76.614039)
                        , new LatLng(2.444777, -76.614857), new LatLng(2.450347, -76.626184))
                .width(10)
                .color(Color.GREEN));
        cuatrotranstimbio = mMap.addPolyline(new PolylineOptions()
                .visible(false)
                .add(new LatLng(2.455519, -76.597619), new LatLng(2.451887, -76.605318)
                        , new LatLng(2.435195, -76.611360), new LatLng(2.437124, -76.616252)
                        , new LatLng(2.444649, -76.614750), new LatLng(2.443170, -76.610974))
                .width(10)
                .color(Color.BLACK));
        cincosotracauca = mMap.addPolyline(new PolylineOptions()
                .visible(false)
                .add(new LatLng(2.455519, -76.597619), new LatLng(2.452243, -76.597696)
                        , new LatLng(2.450548, -76.601485), new LatLng(2.445933, -76.605852)
                        , new LatLng(2.446366, -76.609136), new LatLng(2.446078, -76.614332))
                .width(10)
                .color(Color.RED));
        seistranslibertad = mMap.addPolyline(new PolylineOptions()
                .visible(false)
                .add(new LatLng(2.455519, -76.597619), new LatLng(2.452243, -76.597660)
                        , new LatLng(2.450584, -76.601557), new LatLng(2.445970, -76.605960)
                        , new LatLng(2.446078, -76.607295), new LatLng(2.435236, -76.611308))
                .width(10)
                .color(Color.BLUE));
        sietetranstambo = mMap.addPolyline(new PolylineOptions()
                .visible(false)
                .add(new LatLng(2.455519, -76.597619), new LatLng(2.452243, -76.597674)
                        , new LatLng(2.450458, -76.601603), new LatLng(2.445920, -76.605839)
                        , new LatLng(2.446047, -76.607268), new LatLng(2.451554, -76.605380)
                        , new LatLng(2.448189, -76.613112), new LatLng(2.447271, -76.613852)
                        , new LatLng(2.433276, -76.617139))
                .width(10)
                .color(Color.GREEN));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this
                , Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    public void lineuno(View view)
    {
        lineFalse();
        unosotracauca.setVisible(true);
        Toast.makeText(ConfirmarActivity.this,"La Paz-Alto Cauca-Campanario-Exito Panamericana-Terminal-Esmeralda-Chirimia",Toast.LENGTH_LONG).show();
    }

    public void linedos(View view)
    {

        lineFalse();
        dostranslibertad.setVisible(true);
        Toast.makeText(ConfirmarActivity.this,"La Paz-Alto Cauca-Campanario-Carrera 9-Esmeralda-Chirimia",Toast.LENGTH_LONG).show();
    }

    public void linetres(View view)
    {
        lineFalse();
        trestranstambo.setVisible(true);
        Toast.makeText(ConfirmarActivity.this,"La Paz-Alto Cauca-Campanario-Exito-Terminal-Esmeralda-Pandiguando",Toast.LENGTH_LONG).show();
    }

    public void linecuatro(View view)
    {
        lineFalse();
        cuatrotranstimbio.setVisible(true);
        Toast.makeText(ConfirmarActivity.this,"La Paz-Alto Cauca-Campanario-Toscana-Carrera 9-Calle 13-Chirimia-Esmeralda",Toast.LENGTH_LONG).show();
    }

    public void linecinco(View view)
    {
        lineFalse();
        cincosotracauca.setVisible(true);
        Toast.makeText(ConfirmarActivity.this,"La Paz-Alto Cauca-Campanario-Catai-Estadio-Loteria del Cauca-Esmeralda",Toast.LENGTH_LONG).show();
    }

    public void lineseis(View view)
    {
        lineFalse();
        seistranslibertad.setVisible(true);
        Toast.makeText(ConfirmarActivity.this,"La Paz-Alto Cauca-Campanario-Catai-Hospital San Jose-Loteria del Cauca-Carrera 9-Calle 13",Toast.LENGTH_LONG).show();
    }

    public void linesiete(View view)
    {
        lineFalse();
        sietetranstambo.setVisible(true);
        Toast.makeText(ConfirmarActivity.this,"La Paz-Alto Cauca-Campanario-Catai-Estadio-Loteria del Cauca-Toscana-Terminal-Esmeralda-Chirimia",Toast.LENGTH_LONG).show();
    }
    public void lineFalse()
    {
        unosotracauca.setVisible(false);
        dostranslibertad.setVisible(false);
        trestranstambo.setVisible(false);
        cuatrotranstimbio.setVisible(false);
        cincosotracauca.setVisible(false);
        seistranslibertad.setVisible(false);
        sietetranstambo.setVisible(false);
    }

    public void solibuses(View view)
    {
        Intent intent= new Intent (ConfirmarActivity.this, EsperarActivity.class);
        intent.putExtra("Latlngorigenfinal", direccionorigenfinal);
        intent.putExtra("Latlngdestinofinal",direcciondestinofinal);
        startActivity(intent);
    }

}
