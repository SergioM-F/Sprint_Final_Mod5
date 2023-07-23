package cl.samf.sprint_final_mod5

data class Producto(val nomProducto: String, val urlProducto: String, val valorProducto: Int)

class ProductosList{
    companion object {
        val productos = mutableListOf<Producto>().apply {
            add(Producto("Zapato Clasico 1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVUHAagyD7lvwUEFjn6G0Pok_d9yKsXYm23g&usqp=CAU",45000))
            add(Producto("Zapato Clasico 2","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQOC30eO_xN-X2101Zs7c_qA27Clq1x6evvKg&usqp=CAU", 55000))
            add(Producto("Zapato Clasico 3", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzKXwpRg9HTpnXKSXIMbix2xcq04OGFb48Mg&usqp=CAU", 48500))
            add(Producto("Zapato Clasico 4", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGVtGeAoFG6TaX5wouwKpR32702vMYzXUjR5tLSqr49vdgSTzMKszsh3tQ6ZmOdUAm7DE&usqp=CAU", 40000))
            add(Producto("Zapato Clasico 5", "https://www.veganshoes.it/366417-thickbox_default/zapatos-clasicos-de-hombre-noah-gianni-slip-on-elasticos-veganos.jpg", 43500))
            add(Producto("Zapato Clasico 6", "https://4feetshoes.com/cdn/shop/products/Brown016743-02.jpg?v=1596047675&width=1080", 44500))
            add(Producto("Zapato Clasico 7", "https://4feetshoes.com/cdn/shop/products/Brown016743-03.jpg?v=1596047675&width=1080", 65000))
            add(Producto("Zapato Clasico 8", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQiL-nngOc46BNaBrF4NvhU2DhG0JXFk4kp0g&usqp=CAU", 54990))
            add(Producto("Zapato Clasico 9", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTK7QEUAKM88YuHP9nDYqes9Mp5BJvZib450w&usqp=CAU", 58800))
            add(Producto("Zapato Clasico 10", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4glAcUqKDeaIjluSNgcsM8sKWqa8cppRKhQ&usqp=CAU", 35870))
            add(Producto("Zapato Clasico 11", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJUqR24UOMOujYCh7llH6r3T9RGgkWgXaNzQ&usqp=CAU", 49990))
            add(Producto("Zapato Clasico 12", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZSOxRr-JCqhw_sIOaGt7av3Z3PCFOKC1KYw&usqp=CAU", 69990))
            add(Producto("Zapato Clasico 13", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6dKFzpYJx4BpeyeZLMAFDPuwSu95F8AjuVQ&usqp=CAU", 87800))
            add(Producto("Zapato Clasico 14", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWpLjlTHbGxlGZan39285AhQMAnmICi5ZtCQ&usqp=CAU", 34990))
            add(Producto("Zapato Clasico 15", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9T-fGqlxfdsC330XiSpwUbVW5lAvRQJEVdA&usqp=CAU", 48500))

        }
    }
}


