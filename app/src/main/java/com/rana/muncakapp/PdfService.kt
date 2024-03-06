package com.rana.muncakapp

import android.os.Environment
import com.itextpdf.text.*
import com.itextpdf.text.pdf.BaseFont
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.text.pdf.draw.LineSeparator
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class PdfService {

    private lateinit var pdf: PdfWriter
    lateinit var sharedpref : PreferencesHelper

    val tableFontSize = 8.0f
    val font = Font(Font.FontFamily.HELVETICA, tableFontSize, Font.NORMAL, BaseColor.BLACK)


    private fun createFile(): File {
        //Prepare file
        val title = "Laporan.pdf"
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val file = File(path, title)
        if (!file.exists()) file.createNewFile()
        return file
    }

    private fun createDocument(): Document {
        //Create Document
        val document = Document()
        document.setMargins(24f, 24f, 32f, 32f)
        document.pageSize = PageSize.A4
        return document
    }

    private fun setupPdfWriter(document: Document, file: File) {
        pdf = PdfWriter.getInstance(document, FileOutputStream(file))
        pdf.setFullCompression()
        //Open the document
        document.open()
    }

    fun createUserTable(
        data: ArrayList<Laporan>,
        startDate: String,
        endDate: String,
        onFinish: (file: File) -> Unit,
        onError: (Exception) -> Unit
    ) {
        //Define the document
        val file = createFile()
        val document = createDocument()

        //Custom Font
        val headingFontSize = 17.0f
        val fontName = BaseFont.createFont("res/font/poppins.ttf", "UTF-8", BaseFont.EMBEDDED)
        val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, BaseColor.BLACK)

        //Setup PDF Writer
        setupPdfWriter(document, file)

        // Membuat objek Paragraph untuk judul
        val title = "Laporan Pendakian Basecamp Gunung Andong Via Sawit\n" +
                "Periode ${formatDate(startDate)} - ${formatDate(endDate)}"
        val paragraph = Paragraph(title, headingStyle)
        paragraph.alignment = Element.ALIGN_CENTER // Menetapkan alignment teks ke tengah

        // Menambahkan judul ke dokumen
        document.add(paragraph)

        // Menambahkan garis pemisah setelah judul
        addLineSeparator(document)

        //Define Table
        val nomorWidth = 0.5f // Width for the Nomor column
        val namaReguWidth = 0.7f
        val jumlahReguWidth = 0.5f
        val namaPendakiWidth = 0.7f
        val alamatWidth = 0.7f
        val nohpWidth = 0.7f
        val waktuMulaiWidth = 0.7f
        val waktuSelesaiWidth = 0.7f
        val statusPendakianWidth = 0.7f
        val columnWidth = floatArrayOf(
            nomorWidth, namaReguWidth, jumlahReguWidth, namaPendakiWidth, alamatWidth,
            nohpWidth, waktuMulaiWidth, waktuSelesaiWidth, statusPendakianWidth
        )
        val table = createTable(9, columnWidth) // Increase the total column count to 9

        // Table header (first row)
        val tableHeaderContent = listOf(
            "Nomor", "Nama Regu", "Jumlah Regu", "Nama Pendaki", "Alamat", "No. HP",
            "Tanggal Mulai", "Tanggal Selesai", "Status Pendakian"
        )

        // Write table header into table
        tableHeaderContent.forEach {
            // Define a cell
            val cell = createCell(it)
            // Add our cell into our table
            table.addCell(cell)
        }

        // Write user data into table
        data.forEachIndexed { index, it ->
            // Adding the "Nomor" (number) column with sequential numbering
            val nomorCell = createCell((index + 1).toString())
            table.addCell(nomorCell)

            val namaReguCell = createCell(it.nama_regu.toString())
            table.addCell(namaReguCell)
            val jumlahCell = createCell(it.jumlah_regu.toString())
            table.addCell(jumlahCell)
            val namaPendakiCell = createCell(it.nama_pendaki.toString())
            table.addCell(namaPendakiCell)
            val alamatCell = createCell(it.alamat.toString())
            table.addCell(alamatCell)
            val noHPCell = createCell(it.nohp_pribadi.toString())
            table.addCell(noHPCell)
            val waktuMulaiCell = createCell(it.waktu_mulai.toString())
            table.addCell(waktuMulaiCell)
            val waktuSelesaiCell = createCell(it.waktu_selesai.toString())
            table.addCell(waktuSelesaiCell)
            val statusCell = createCell(it.status_pendakian.toString())
            table.addCell(statusCell)
        }

        document.add(table)
        document.close()

        try {
            pdf.close()
        } catch (ex: Exception) {
            onError(ex)
        } finally {
            onFinish(file)
        }
    }

    @Throws(DocumentException::class)
    private fun addLineSeparator(document: Document) {
        val lineSeparator = LineSeparator()
        lineSeparator.lineColor = BaseColor(0,0,0,68)
        addLineSpace(document)
        document.add(Chunk(lineSeparator))
        addLineSpace(document)
    }

    @Throws(DocumentException::class)
    private fun addLineSpace(document: Document) {
        document.add(Paragraph(""))
    }

    @Throws(DocumentException::class)
    private fun createTable(column: Int, columnWidth: FloatArray): PdfPTable {
        val table = PdfPTable(column)
        table.widthPercentage = 100f
        table.setWidths(columnWidth)
        table.headerRows = 1
        table.defaultCell.verticalAlignment = Element.ALIGN_CENTER
        table.defaultCell.horizontalAlignment = Element.ALIGN_CENTER
        return table
    }

    @Throws(DocumentException::class)
    private fun createCell(content: String): PdfPCell {
        val cell = PdfPCell(Phrase(content, font))
        cell.horizontalAlignment = Element.ALIGN_CENTER
        cell.verticalAlignment = Element.ALIGN_MIDDLE
        //setup padding
        cell.setPadding(8f)
        cell.isUseAscender = true
        cell.paddingLeft = 4f
        cell.paddingRight = 4f
        cell.paddingTop = 8f
        cell.paddingBottom = 8f
        return cell
    }

    private fun formatDate(date: String): String {
        val inputFormat = SimpleDateFormat("yyyy/MM/dd", Locale.US)
        val outputFormat = SimpleDateFormat("dd MMMM yyyy", Locale.US)
        val parsedDate = inputFormat.parse(date)
        return outputFormat.format(parsedDate!!)
    }


}