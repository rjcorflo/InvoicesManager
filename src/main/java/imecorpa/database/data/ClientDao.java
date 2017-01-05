package imecorpa.database.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Solus on 02/01/2017.
 */
@DatabaseTable(tableName = "client")
public class ClientDao
{
    @DatabaseField(generatedId = true)
    private int id_cliente;
    @DatabaseField
    private String cif;
    @DatabaseField
    private String nombre_cliente;
    @DatabaseField
    private String apellido1_cliente;
    @DatabaseField
    private String apellido2_cliente;
    @DatabaseField
    private String domicilio;
    @DatabaseField
    private String codigo_postal;
    @DatabaseField
    private String localidad;
    @DatabaseField
    private String provincia;
    @DatabaseField
    private String telefono;
    @DatabaseField
    private String fax;
    @DatabaseField
    private String iban;
    @DatabaseField
    private String ccc;
    @DatabaseField
    private String id_tipo_pago;
    @DatabaseField
    private String CUENTACAJA;
    @DatabaseField
    private String CAJA;
    @DatabaseField
    private String CIF_OFICIAL;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido1_cliente() {
        return apellido1_cliente;
    }

    public void setApellido1_cliente(String apellido1_cliente) {
        this.apellido1_cliente = apellido1_cliente;
    }

    public String getApellido2_cliente() {
        return apellido2_cliente;
    }

    public void setApellido2_cliente(String apellido2_cliente) {
        this.apellido2_cliente = apellido2_cliente;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCcc() {
        return ccc;
    }

    public void setCcc(String ccc) {
        this.ccc = ccc;
    }

    public String getId_tipo_pago() {
        return id_tipo_pago;
    }

    public void setId_tipo_pago(String id_tipo_pago) {
        this.id_tipo_pago = id_tipo_pago;
    }

    public String getCUENTACAJA() {
        return CUENTACAJA;
    }

    public void setCUENTACAJA(String CUENTACAJA) {
        this.CUENTACAJA = CUENTACAJA;
    }

    public String getCAJA() {
        return CAJA;
    }

    public void setCAJA(String CAJA) {
        this.CAJA = CAJA;
    }

    public String getCIF_OFICIAL() {
        return CIF_OFICIAL;
    }

    public void setCIF_OFICIAL(String CIF_OFICIAL) {
        this.CIF_OFICIAL = CIF_OFICIAL;
    }
}
