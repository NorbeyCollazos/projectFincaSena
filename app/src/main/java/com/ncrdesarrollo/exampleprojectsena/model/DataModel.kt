package com.ncrdesarrollo.exampleprojectsena.model

data class DataModel(val title: String) {

    companion object {
        fun getListData(): List<DataModel> {
            val list = mutableListOf<DataModel>()
            list.add(DataModel(title = "Este es el primer dato"))
            list.add(DataModel(title = "Este es el segundo dato"))
            list.add(DataModel(title = "Este es el tercer dato"))

            return list
        }
    }
}
