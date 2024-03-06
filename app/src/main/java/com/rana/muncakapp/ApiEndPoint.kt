package com.rana.muncakapp

class ApiEndPoint {

    companion object {
        private val SERVER = "http://infoandongviasawit.000webhostapp.com/api_android/"

        //CREATE var
        val CREATE_pendakian = SERVER+"create_pendakian.php"
        val CREATE_pendaki = SERVER+"create_pendaki.php"
        val CREATE_user = SERVER+"create_user.php"
        val CREATE_riwayat_pendakian = SERVER+"create_riwayat_pendakian.php"

        //READ var
        val READ_pendakian = SERVER+"read_pendakian.php"
        val READ_pendaki = SERVER+"read_pendaki.php"
        val READ_riwayat = SERVER+"read_rencana_pendakian.php"
        val READ_user = SERVER+"read_user.php"
        val READ_riwayat_pendaki = SERVER+"read_pendaki_user.php"
        val READ_laporan_pendakian = SERVER+"cek_laporan_pendakian.php"
        val READ_riwayat_pendakian = SERVER+"read_riwayat_pendakian.php"
        val READ_riwayat_pendakian_user = SERVER+"read_riwayat_pendakian_user.php"

        //UPDATE var
        val UPDATE_pendakian = SERVER+"update_pendakian.php"
        val UPDATE_pendaki = SERVER+"update_pendaki.php"
        val UPDATE_user = SERVER+"update_profil.php"
        val UPDATE_riwayat_pendakian = SERVER+"update_riwayat_pendakian.php"

        //DELETE var
        val DELETE_pendakian = SERVER+"delete_pendakian.php"
        val DELETE_pendaki = SERVER+"delete_pendaki.php"
        val DELETE_riwayat_pendakian = SERVER+"delete_riwayat_pendakian.php"

    }


}