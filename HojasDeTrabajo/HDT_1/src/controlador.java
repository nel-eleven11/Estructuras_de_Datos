package src;
/*
 * HDT 1 Algorigmos y estructura de datos
 * Nelson García Bravatti
 * Joaquín Puente
 * Oscar Fuentes
 * Clase controlador
 */

public class controlador {

    public IRadio radio = new radio();

    public void turnOnOff() {
        if(radio.isOn()){
            radio.off();
        }else{
            radio.on();
        }
    }

    
    /** 
     * @throws Exception
     */
    public void changeFrequence() throws Exception {
        radio.setFrequence(radio.getFrequence());
    }
    
    /** 
     * @return String
     */
    public String getFrequence(){
        return radio.getFrequence();
    }
    
    /** 
     * @return int
     */
    public int getAMActualStation(){
        return radio.getAMActualStation();
    }
    
    /** 
     * @return double
     */
    public double getFMActualStation(){
        return radio.getFMActualStation();
    }

    public void forward(){
        radio.Forward();
    }

    public void backward(){
        radio.Backward();
    }

    
    /** 
     * @param slot
     */
    public void saveStation(int slot){
        if(radio.getFrequence().equals("AM")){
            radio.saveAMStation(radio.getAMActualStation(), slot);
        }else{
            radio.saveFMStation(radio.getFMActualStation(), slot);
        }
    }

    
    /** 
     * @param slot
     */
    public void selectFavoriteSation(int slot){
        if(radio.getFrequence().equals("AM")){
            radio.setAMActualStation(radio.getAMSlot(slot));
        }else{
            radio.setFMActualStation(radio.getFMSlot(slot));
        }

    }

}
