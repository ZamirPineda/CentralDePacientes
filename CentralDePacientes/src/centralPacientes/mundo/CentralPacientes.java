/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�as de la Informaci�n y Comunicaciones
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
     * Vector de cl�nicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de cl�nicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Cl�nica del Country");
        listaClinicas.add("Cl�nica Palermo");
        listaClinicas.add("Cl�nica Reina Sof�a");
        listaClinicas.add("Cl�nica El Bosque");
        listaClinicas.add("Cl�nica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de pacientes de la cl�nica
     *
     * @return El n�mero de pacientes de la cl�nica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        // TODO: Realiar el m�todo que agrega al principio
        pacientes.add(0, pac); // Se especifica la posici�n 0 para que siempre sea al comienzo
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista est� vac�a el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        // TODO: Agragar un paciente al final de la lista
        pacientes.add(pac); // No se especifica posicion para que siempre lo agregue al final de la lista
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el c�digo especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente despu�s del paciente con el c�digo dado
        int indice = -1; // -1 para que no pueda ser un paciente, ya que, los codigos de los pacientes solo pueden ser postivos
        int longitud = darLongitud(); // Longitud de la lista de pacientes
        for (int i = 0; i < longitud; i++) {
            if (pacientes.get(i).darCodigo() == cod) { // Si el codigo del paciente es igual al de la posicion, le da ese valor al indice
                indice = i;
                break; // No puede ir detras de varios indices xd
            }
        }
        if (indice != -1) { // Si es diferente de -1 es porque encontro una coincidencia entre el indice y el paciente
            pacientes.add(indice, pac); // Este indice es el mismo que cod, por lo cual al agregar a la lista, lo pondra esta posici�n, agregandole antes de cod
        } else {
            throw new NoExisteException(cod); // Si es -1, es porque no encontro ninguno, y lanzamos el error, que ya estaba por defecto
        }
    }

    /**
     * Adiciona un paciente a la lista de pacientes despu�s del paciente con el c�digo especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente despu�s del paciente con el c�digo cod
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
     * Busca el paciente con el c�digo dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        // TODO: Completar el m�todo
        for (Paciente pac : pacientes) {
            if (pac.darCodigo() == codigo) {
                return pac;
            }
        }
        return null;
    }

    /**
     * Elimina el paciente con el c�digo especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // TODO: Si no existe el paciente con el c�digo dado, genera la excepci�n
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
     * Retorna la lista de cl�nicas manejadas por la central
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
    // Puntos de Extensi�n
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
     * De las 6 opciones de cl�nicas que tiene la central
     * �Cu�l es el nombre de la m�s ocupada, la que tiene m�s pacientes?
     *
     * @return nombre de la cl�nica
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
