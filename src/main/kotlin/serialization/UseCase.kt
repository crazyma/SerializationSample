package serialization

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import model.BigNumber
import model.Education
import model.Machine
import model.Persona

object UseCase {

    fun polymorphic() {
        val module = SerializersModule {
            polymorphic(Machine.Vehicle::class) {
                subclass(Machine.Vehicle.Car::class, Machine.Vehicle.Car.serializer())
                subclass(Machine.Vehicle.Motor::class, Machine.Vehicle.Motor.serializer())
                subclass(Machine.Vehicle.Bike::class, Machine.Vehicle.Bike.serializer())
            }
        }
        val json = Json {
            serializersModule = module
            coerceInputValues = true
            encodeDefaults = true
        }
        val car = Machine.Vehicle.Car(serialNumber = 333L)
        println(
            json.encodeToString(
                Machine.Vehicle.serializer(),
                car
            )
        ) // This method would create an additional property: `type`
        println(json.encodeToJsonElement(car))
    }

    fun merge2JsonObject() {
        val persona = Persona(name = "Batu", age = 33)
        val education = Education(seniorHighSchool = "NTFSH", college = "NTU")
        val jsonPersona = Json.encodeToJsonElement(Persona.serializer(), persona).jsonObject
        val jsonEducation = Json.encodeToJsonElement(Education.serializer(), education).jsonObject
        println(Json.encodeToString(persona))
        val jsonObject = jsonPersona.append(jsonEducation)
        println("result : $jsonObject")
    }

    fun bigNumber() {
        val jsonString = "{ \"data\": 10000000 }"
        val bigNumber = Json.decodeFromString(BigNumber.serializer(), jsonString)
        println("data: ${bigNumber.data}")
    }
}