package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class Machine{
    @Serializable
    abstract class Vehicle: Machine(){

        abstract val serialNumber: Long?

        @SerialName("typeName")
        abstract val typeName: String

        @Serializable
        data class Car(override val serialNumber: Long? = null): Vehicle() {
            @SerialName("typeName") override val typeName: String
                get() = "car"
        }

        @Serializable
        data class Motor(override val serialNumber: Long): Vehicle(){
            @SerialName("typeName") override val typeName: String
                get() = "motor"
        }


        @Serializable
        data class Bike(override val serialNumber: Long): Vehicle(){
            @SerialName("typeName") override val typeName: String
                get() = "bike"
        }
    }
}





