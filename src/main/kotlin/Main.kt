// Declaramos los valores de nuestras respuestas
const val RESPUESTA_AFIRMATIVA = "✅"
const val RESPUESTA_NEGATIVA = "❌"
const val RESPUESTA_DUDOSA = "?"

//Unimos las respuestas con los valores
val respuestas = mapOf(
    "Sí" to RESPUESTA_AFIRMATIVA,
    "Es cierto" to RESPUESTA_AFIRMATIVA,
    "Totalmente" to RESPUESTA_AFIRMATIVA,
    "Sin duda" to RESPUESTA_AFIRMATIVA,
    "Pregunta en otro momento" to RESPUESTA_DUDOSA,
    "No puedo decirte en este momento" to RESPUESTA_DUDOSA,
    "Puede que si o puede que no" to RESPUESTA_DUDOSA,
    "No va a suceder" to RESPUESTA_NEGATIVA,
    "No cuentes con ello" to RESPUESTA_NEGATIVA,
    "Definitivamente no" to RESPUESTA_NEGATIVA,
    "No lo creo" to RESPUESTA_NEGATIVA,
)
var continuar = true

fun main() {

    while (continuar){

        println("Hola soy tu bola 8 magica creada enKotlin. Cual de estas opciones deseas realizar?")
        println("1. Realizar una pregunta")
        println("2. Revisar todas las respuestas")
        println("3. Salir")


    //leer el valor ingresado
    val valorIngresado = readLine()

    when(valorIngresado){
        "1"-> realizarPregunta()
        "2"-> mostrarRespuestas()
        "3"-> Salir()
        else-> mostrarError()
        }
    }
}

fun mostrarError() {
    println("Esa opción no es valida, Intenta de nuevo")
}

fun Salir() {
    continuar = false
    println("hasta luego!")
}

fun mostrarRespuestas() {
    println("Selecciona una opcion")
    println("1.Revisar todas las respuestas")
    println("2.Revisar solo las respuestas afirmativas")
    println("3.Revisar solo las respuestas dudodas")
    println("4.Revisar solo las respuestas negativas")
    val opcionIngresada = readLine()
    when(opcionIngresada){
        "1"-> mostrarRespuestasPorTipo()
        "2"-> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_AFIRMATIVA)
        "3"-> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_DUDOSA)
        "4"-> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_NEGATIVA)
        else-> println("Respuesta no valida. Adios")
    }
}

fun mostrarRespuestasPorTipo(tipoDeRespuesta : String = "TODOS"){
    val respuestrasFiltradas = when(tipoDeRespuesta){
        "TODOS" ->respuestas
        else -> respuestas.filterValues { it == tipoDeRespuesta }
    }
    respuestrasFiltradas.keys.forEach{respuestas -> println(respuestas)}
}

fun realizarPregunta(){
    println("Que pregunta deseas realizar?")
    readLine()
    println("Así que esa era tu pregunta... La respuesta a eso es:")
    val respuestaGenerada = respuestas.keys.random()
    println(respuestaGenerada)
}



