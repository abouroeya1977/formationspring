package ma.formations.domaine;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpPaginator {
	private List<EmpVo> employees=new ArrayList<EmpVo>();
	private Long size;
}
