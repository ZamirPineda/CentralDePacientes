/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de clínicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de clínicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Clínica del Country");
        listaClinicas.add("Clínica Palermo");
        listaClinicas.add("Clínica Reina Sofía");
        listaClinicas.add("Clínica El Bosque");
        listaClinicas.add("Clínica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el número de pacientes de la clínica
     *
     * @return El número de pacientes de la clínica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        // TODO: Realiar el método que agrega al principio
        pacientes.add(0, pac); // Se especifica la posición 0 para que siempre sea al comienzo
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista está vacía el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        // TODO: Agragar un paciente al final de la lista
        pacientes.add(pac); // No se especifica posicion para que siempre lo agregue al final de la lista
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el código especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente después del paciente con el código dado
        int indice = -1; // -1 para que no pueda ser un paciente, ya que, los codigos de los pacientes solo pueden ser postivos
        int longitud = darLongitud(); // Longitud de la lista de pacientes
        for (int i = 0; i < longitud; i++) {
            if (pacientes.get(i).darCodigo() == cod) { // Si el codigo del paciente es igual al de la posicion, le da ese valor al indice
                indice = i;
                break; // No puede ir detras de varios indices xd
            }
        }
        if (indice != -1) { // Si es diferente de -1 es porque encontro una coincidencia entre el indice y el paciente
            pacientes.add(indice, pac); // Este indice es el mismo que cod, por lo cual al agregar a la lista, lo pondra esta posición, agregandole antes de cod
        } else {
            throw new NoExisteException(cod); // Si es -1, es porque no encontro ninguno, y lanzamos el error, que ya estaba por defecto
        }
    }

    /**
     * Adiciona un paciente a la lista de pacientes después del paciente con el código especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente después del paciente con el código cod
        int indice = -1; // -1 para que no pueda ser un paciente, ya que, los codigos de los pacientes solo pueden ser postivos
        int longitud = darLongitud(); // Longitud de la lista de pacientes
        for (int i = 0; i < longitud; i++) {
            if (pacientes.get(i).darCodigo() == cod) { // Si el codigo del paciente es igual al de la posicion, le da ese valor al indice
                indice = i;
                break; // No puede ir detras de varios indices xd
            }
        }
        if (indice != -1) { // Si es diferente de -1 es porque encontro una coincidencia entre el indice y el paciente
            pacientes.add(indice+1, pac); // Este indice es el mismo que cod, por lo cual al agregar a la lista con +1, lo pondra despues de cod
        } else {
            throw new NoExisteException(cod); // Si es -1, es porque no encontro ninguno, y lanzamos el error, que ya estaba por defecto
        }
    }

    /**
     * Busca el paciente con el código dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        // TODO: Completar el método
        for (Paciente pac : pacientes) {
            if (pac.darCodigo() == codigo) {
                return pac;
            }
        }
        return null;
    }

    /**
     * Elimina el paciente con el código especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // TODO: Si no existe el paciente con el código dado, genera la excepción
        Paciente paciente = null; // Se instancia en en null para la ultima condicional
        for (Paciente pac : pacientes) {
            if (pac.darCodigo() == cod) {
                paciente = pac;
                break;
            }
        }
        if (paciente != null) {
            pacientes.remove(paciente);
        } else {
            throw new NoExisteException(cod);
        }
    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de clínicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
        // TODO: Completar
        int contador = 0;
        for (Paciente pac : pacientes) {
            if (pac.darSexo() == Paciente.HOMBRE) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        // TODO: Completar
        int contador = 0;
        for (Paciente pac : pacientes) {
            if (pac.darSexo() == Paciente.MUJER) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * De las 6 opciones de clínicas que tiene la central
     * ¿Cuál es el nombre de la más ocupada, la que tiene más pacientes?
     *
     * @return nombre de la clínica
     */
    public String metodo4() {
        // TODO: Completar
        String clinicaMasOcupada = "";
        int maxPacientes = -1;
        for (String clinica : listaClinicas) {
            int pacientesEnClinica = contarPacientesEnClinica(clinica);
            if (pacientesEnClinica > maxPacientes) {
                maxPacientes = pacientesEnClinica;
                clinicaMasOcupada = clinica;
            }
        }
        return clinicaMasOcupada;
    }

    private int contarPacientesEnClinica(String clinica) {
        int count = 0;
        for (Paciente pac : pacientes) {
            if (pac.darClinica().equals(clinica)) {
                count++;
            }
        }
        return count;
    }
        //return "Respuesta 4";
}
