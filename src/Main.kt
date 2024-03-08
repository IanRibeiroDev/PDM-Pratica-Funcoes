import java.util.Locale

/*
//////////////////////////
Leia o corpo do main para entender a atividade;
//////////////////////////
*/

val materiasENotas = mutableMapOf<String, MutableList<Double>>()

/**
 * Adiciona uma disciplina no dicionário mutável,
 * Recebe um array de notas (opcional)
 * Retorna true se conseguiu, false se não.
 */
fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
    return materiasENotas.put(materia, notas) != null
}

/**
 * Adiciona uma nota à lista de notas de uma determinada matéria;
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}


/**
 *Mostra na tela todas as notas presentes em uma matéria, no seguinte formato:
 * Materia: {nome da materia}
 * Nota 1: 5.4 \n
 * Nota 2: 7.8 \n
 * ...
 * Nota n: 10 \n
 * Caso não encontre a materia no map, mostre:
 * Materia {nome da materia} não encontrada \n
 * Caso não seja possível mostar as notas, mostre:
 * Não foi possível mostrar as notas da matéria {nome da materia} \n
 */
fun mostrarNotas(materia:String){

    if(!materiasENotas.containsKey(materia)){
        println("Materia $materia não encontrada")
    }
    else{
        val listaNotas = materiasENotas[materia]

        if (listaNotas != null) {
            var cont = 1
            for(nota:Double in listaNotas){
                println("Nota ${cont++}: $nota")
            }
            println("Média: ${"%.2f".format(calcularMedia(materia))}")
        }
        else{
            println("Não foi possível mostrar as notas da matéria $materia")
        }
    }


}

/*
Retorna a média obtida apartir de uma lista de notas
*/
fun calcularMedia(materia: String): Double? {
    val notasDaMateria = materiasENotas[materia]

    return if(!notasDaMateria.isNullOrEmpty()) {
        var soma = 0.0
        notasDaMateria.forEach { soma += it }
        soma / notasDaMateria.size
    } else {
        null
    }
}


/**
 *Adiciona várias notas de uma só vez em uma matéria
 * retorne true se conseguiu adicionar, false se não consegiu.
 * */
fun adicionarVariasNotas(materia:String, vararg nota:Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if(notasDaMateria != null && nota.isNotEmpty()) {
        nota.forEach { notasDaMateria.add(it) }
        true
    } else {
        false
    }
}


fun main(){
    Locale.setDefault(Locale.US)
    // 1. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição possicional
    adicionarDisciplina("PDM", mutableListOf(9.5, 8.7, 10.0, 8.9))

    // 2. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição nomeada
    adicionarDisciplina(notas = mutableListOf(9.3, 7.7, 9.0, 9.9), materia = "PWEB1")

    // 3. adicionarDisciplinas -> altere a função adicionarDisciplinas para que o parametros notas seja opcional. Dica: utilize mutableListOf()
    // A prática já veio com essa alteração implementada :/

    // 4. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, sem atribuir valores a notas
    adicionarDisciplina("PWEB2")

    // 5. adicionarNota -> adicione 3 notas para as 3 disciplinas
    adicionarNota("PDM", 7.0)
    adicionarNota("PDM", 9.5)
    adicionarNota("PDM", 8.1)

    adicionarNota("PWEB1", 6.1)
    adicionarNota("PWEB1", 9.0)
    adicionarNota("PWEB1", 7.0)

    adicionarNota("PWEB2", 9.0)
    adicionarNota("PWEB2", 9.5)
    adicionarNota("PWEB2", 10.0)

    // 6. mostrarNotas -> Mostre as notas das 3 disciplinas
    mostrarNotas("PDM")
    mostrarNotas("PWEB1")
    mostrarNotas("PWEB2")

    // 7. adicionarDisciplina -> adicione mais 1 disciplina
    adicionarDisciplina("PWEB3")

    // 8. adicionarVariasNotas -> implemente o metodo adicionarVariasNotas();
    // Feito

    // 9. adicionarVariasNotas -> adicione 3 notas para a disciplina que você acabou de criar
    adicionarVariasNotas("PWEB3", 8.7, 9.2, 7.3)

    // 10. mostrarNotas -> mostre as notas da disciplina que você acabou de criar;
    mostrarNotas("PWEB3")

    // Bônus: (Não vai ganhar nada, ou melhor, vai ganhar mais conhecimento >:O)
    // 11: calcularMedia -> Implemente a função calcularMedia()
    // Feito

    // 12: calcularMedia -> calcule a media de 2 disciplinas
    calcularMedia("PWEB1")
    calcularMedia("PWEB2")

    // 13: mostrarNotas -> altere o mostrarNotas() para que ele mostre também a media das disciplinas
    // Feito

    // 14: mostrarNotas -> mostre as notas de 1 disciplina
    mostrarNotas("PWEB3")
}