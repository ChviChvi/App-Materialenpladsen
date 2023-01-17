package com.example.materialepladsen.viewmodel



data class Material(
    val materialName: String,
    val productSize:String,
    val materialPrice: Float,
    val picture:String,

)



val Genbrugsmaterialer = listOf(
    Material("Asfalt knust","0-20 mm", 0.39F,"https://www.materialepladsen.dk/images/productimages/Asfaltknust0-20mm_7e084a14-673f-430c-a7de-739474b6d113.jpg"),
    Material(materialName = "Betonstabilt", productSize ="0-32 mm" , materialPrice =0.31F , picture = "https://www.materialepladsen.dk/images/productimages/Betonstabilt0-32mm_a2d89118-db10-4fe7-b65f-5e1c8fcc50d9.jpg")
)

val Granitskærver = listOf(
    Material(materialName = "Granit rød", productSize ="11-16 mm" , materialPrice =0.80F , picture = "https://www.materialepladsen.dk/images/productimages/Granitrød11-16mm_76209b39-4244-4fb6-a91f-8c082f4d98e7.jpg"),
    Material(materialName = "Granit rød", productSize ="20-50 mm" , materialPrice =0.80F , picture = "https://www.materialepladsen.dk/images/productimages/Granitrød20-50mm_c0d00142-aec5-48a4-8718-94d55f2cd878.jpg"),
    Material(materialName = "Granit rød", productSize = "4-8 mm", materialPrice = 080F, picture = "https://www.materialepladsen.dk/images/productimages/Granitrød4-8mm_4be2ae7c-7ea1-4280-98b9-bfec79dd4257.jpg"),
    Material(materialName = "Granit sort", productSize = "8-11 mm", materialPrice = 0.85F, picture = "https://www.materialepladsen.dk/images/productimages/Granitsort8-11mm_20ffb035-5f70-4cdd-a723-bce274d3a5c8.jpg"),
    Material(materialName = "Granit rød", productSize = "16-25 mm", materialPrice = 0.80F, picture = "https://www.materialepladsen.dk/images/productimages/Granitrød16-25mm_fd013466-a85c-4881-a919-d0a1822cb7fb.jpg"),
    Material(materialName = "Granit sort", productSize = "11-16 mm", materialPrice = 0.85F, picture = "https://www.materialepladsen.dk/images/productimages/Granitsort11-16mm_8cb787d7-d608-49e4-8f8d-0a72dec2f014.jpg"),
    Material(materialName = "Granit sort", productSize = "16-22 mm", materialPrice = 0.85F, picture = "https://www.materialepladsen.dk/images/productimages/Granitsort16-22mm_86f20a44-d886-4317-873c-f508f897392f.jpg"),
    )

val GrusOgSand = listOf(
    Material(materialName = "Støbegrus", productSize ="0-4 mm" , materialPrice =039F , picture = "https://www.materialepladsen.dk/images/productimages/Støbegrus0-4mm_a7f26b5d-2266-4a01-a5fb-3ee2463f037a.jpg"),
    Material(materialName = "Vejgrus", productSize ="0-8 mm" , materialPrice =0.39F , picture = "https://www.materialepladsen.dk/images/productimages/Vejgrus0-8mm_c33473d6-aefe-41a7-bf45-22c9dbc9b81e.jpg"),
    Material(materialName = "Stabilgrus", productSize = "0-32 mm", materialPrice = 0.39F, picture = "https://www.materialepladsen.dk/images/productimages/Stabilgrus0-32mm_a66d0d81-eaea-44d8-9e26-444367b82c35.jpg"),
    Material(materialName = "Flisegrus", productSize = "0-8 mm", materialPrice = 0.39F, picture = "https://www.materialepladsen.dk/images/productimages/Flisegrus0-8mm_4c0a9661-22cb-40a8-a3e4-11c7ac800bf6.jpg"),
    Material(materialName = "Støbemix", productSize = "0-16 mm", materialPrice = 0.55F, picture = "https://www.materialepladsen.dk/images/productimages/Støbemix0-16mm_ccd41cbd-7307-4c7e-addf-051bb5c652e7.jpg"),
    Material(materialName = "Strandsand", productSize = "0-2 mm", materialPrice = 0.55F, picture = "https://www.materialepladsen.dk/images/productimages/Strandsand0-2mm_2b923e82-0a8c-409a-bd52-9da444bf0579.jpg"),
    Material(materialName = "Støbemix", productSize = "0-8 mm", materialPrice = 0.55F, picture = "https://www.materialepladsen.dk/images/productimages/Støbemix0-8mm_3b783f77-5f66-40e6-b0ce-92986d6fce40.jpg"),
)

val JordOgMuld = listOf(
    Material(materialName = "Muldjord Harpet", productSize ="0-10 mm" , materialPrice =0.45F , picture = "https://www.materialepladsen.dk/images/productimages/MuldjordHarpet0-10mm_cdecced4-3de3-4cda-8220-246636c38936.jpg"),
    Material(materialName = "Plantemuld", productSize ="Ingen data" , materialPrice =1.12F , picture = "https://www.materialepladsen.dk/images/productimages/Plantemuld_c399a6cd-81e1-447d-a1c7-d76bac331510.jpg"),
    Material("Spagnum","Ingen data", 1.95F,"https://www.materialepladsen.dk/images/productimages/Spagnum_e4c811ba-ff22-45d8-9ed1-416f910ca25e.jpg"),
    Material("Topdress","0-8 mm",0.75F,"https://www.materialepladsen.dk/images/productimages/Topdress0-8mm_bac64fc4-c80e-40da-a5b5-c2abdabbdb76.jpg")
)

val Sten = listOf(
    Material(materialName = "Ærtesten", productSize ="8-16 mm" , materialPrice =0.55F , picture = "https://www.materialepladsen.dk/images/productimages/Ærtesten8-16mm_da84a4d1-aac8-4032-8d83-a8dad4fe0296.jpg"),
    Material(materialName = "Perlesten", productSize ="5-8 mm" , materialPrice =0.55F , picture = "https://www.materialepladsen.dk/images/productimages/Perlesten5-8mm_d2888a49-4aff-4fd3-b02d-370137225320.jpg"),
    Material("Pigsten","150-200 mm",1.50F,"https://www.materialepladsen.dk/images/productimages/Pigsten150-200mm_7640a47d-b748-4cbd-87e4-5befb3bdf90a.jpg"),
    Material("Pyntesingels","32-70 mm",1.50F,"https://www.materialepladsen.dk/images/productimages/Pyntesingels32-70mm_f4acc488-4798-45e7-aa8b-4d5e86e674a7.jpg"),
    Material("Nøddesten","16-32 mm",0.55F,"https://www.materialepladsen.dk/images/productimages/Nøddesten16-32mm_385292e5-ae30-41b9-8a4e-ada20bca0a79.jpg")
)

val TræflisOgBark = listOf(
    Material(materialName = "Træflis", productSize ="Ingen data" , materialPrice =1.95F , picture = "https://www.materialepladsen.dk/images/productimages/Træflis_70afa43f-456c-417b-966f-979498f7f67b.jpg"),
    Material(materialName = "Bark", productSize ="Ingen data" , materialPrice =1.95F , picture = "https://www.materialepladsen.dk/images/productimages/Bark_80a40a07-2203-493b-9b3f-0770c5f56989.jpg")
)


fun <T> merge(first: List<T>, second: List<T>, third: List<T>, fourth: List<T>, fifth:List<T>, sixth:List<T>): List<T> {
    return first + second + third + fourth + fifth + sixth
}


var MaterialList: List<Material> = merge(Genbrugsmaterialer, Granitskærver, GrusOgSand, JordOgMuld, Sten,
        TræflisOgBark )


