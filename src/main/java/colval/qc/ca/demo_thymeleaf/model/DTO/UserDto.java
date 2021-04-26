package colval.qc.ca.demo_thymeleaf.model.DTO;

import colval.qc.ca.demo_thymeleaf.model.DTO.DataDTO;
import colval.qc.ca.demo_thymeleaf.model.DTO.SupportDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @JsonProperty("data")
    private DataDTO dataDTO;

    @JsonProperty("support")
    private SupportDTO supportDTO;

    public DataDTO getDataDTO() {
        return dataDTO;
    }

    public void setDataDTO(DataDTO dataDTO) {
        this.dataDTO = dataDTO;
    }

    public SupportDTO getSupportDTO() {
        return supportDTO;
    }

    public void setSupportDTO(SupportDTO supportDTO) {
        this.supportDTO = supportDTO;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "dataDTO=" + dataDTO +
                ", supportDTO=" + supportDTO +
                '}';
    }
}

