package src;
/*
 * HDT 1 Algorigmos y estructura de datos
 * Nelson García Bravatti
 * Joaquín Puente
 * Oscar Fuentes
 * Clase radio
 */

public class radio implements IRadio {

    private boolean on;
    private String frequence;
    private double FMActualStation;
    private int AMActualStation;
    private double[] FMSlot = new double[12];
    private int[] AMSlot = new int[12];

    public radio(){
        on = false;
        frequence = "AM";
        FMActualStation = 87.9;
        AMActualStation = 530;
    }

    public void on(){
        on = true;
    }

    public void off(){
        on = false;
    }

    
    /** 
     * @return boolean
     */
    public boolean isOn(){
        return on;
    }

    
    /** 
     * @param freq
     * @throws Exception
     */
    public void setFrequence(String freq) throws Exception{
        try {
            if(freq.equals("AM") ){
                frequence = "FM";
            }else if(freq.equals("FM")){
                frequence = "AM";
            }else{
                throw new Exception("Error");
            }
        } catch (Exception e) {
            System.out.println("Error");
        }

    }

    
    /** 
     * @return String
     */
    public String getFrequence(){
        return frequence;
    }

    public void Forward(){
        if(frequence.equals("AM")){
            if(AMActualStation == 1610){
                AMActualStation = 530;
            }else{
                AMActualStation += 10;
            }
        }else{
            if(FMActualStation == 107.9){
                FMActualStation = 87.9;
            }else{
                FMActualStation = Math.round((FMActualStation + 0.2) * 10.0) / 10.0;
            }
        }
    }

    public void Backward(){
        if(frequence.equals("AM")){
            if(AMActualStation == 530){
                AMActualStation = 1610;
            }else{
                AMActualStation -= 10;
            }
        }else{
            if(FMActualStation == 87.9){
                FMActualStation = 107.9;
            }else{
                FMActualStation = Math.round((FMActualStation - 0.2) * 10.0) / 10.0;
            }
        }
    }

    
    /** 
     * @return double
     */
    public double getFMActualStation(){
        return FMActualStation;
    }

    
    /** 
     * @return int
     */
    public int getAMActualStation(){
        return AMActualStation;
    }

    
    /** 
     * @param actualStation
     */
    public void setFMActualStation(double actualStation){
        FMActualStation = actualStation;
    }

    
    /** 
     * @param actualStation
     */
    public void setAMActualStation(int actualStation){
        AMActualStation = actualStation;
    }

    
    /** 
     * @param actualStation
     * @param slot
     */
    public void saveFMStation(double actualStation, int slot){
        FMSlot[slot] = actualStation;
    }

    
    /** 
     * @param actualStation
     * @param slot
     */
    public void saveAMStation(int actualStation, int slot){
        AMSlot[slot] = actualStation;
    }

    
    /** 
     * @param slot
     * @return double
     */
    public double getFMSlot(int slot){
        return FMSlot[slot];
    }

    
    /** 
     * @param slot
     * @return int
     */
    public int getAMSlot(int slot){
        return AMSlot[slot];
    }
}
