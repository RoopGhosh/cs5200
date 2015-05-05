
import javaapplication1.MainClass;


public class Arthi2 extends MainClass
{
	private int line_number;
	public static boolean occupied;
	private boolean is_this_stage_required;
	private boolean is_this_stage_completed;
	private boolean is_in_scope;
	private int cc;

	float Reg_imm;
	boolean has_finished_execution;
	
	Arthi2(int from_constructor)
	{
		cc=0;
		is_in_scope=false;
		is_this_stage_required=false;
		is_this_stage_completed=false;
		has_finished_execution=false;
	}
	public int getcc() {
		return cc;
	}
	public void setcc(int cc) {
		this.cc = cc;
	}
	Arthi2(boolean from_constructor,int line_Number)
	{
		is_in_scope=true;
		line_number=line_Number;
		is_this_stage_required=true;
		occupied=true;
		is_this_stage_completed=true;
		Instruction_Sequence.set(line_Number, Instruction_Sequence.get(line_Number)+"A2        ");
		Reg_imm=get_ID_value2(line_number)+get_ID_value3(line_number);
		set_ID_values_of_operand1(line_number,Reg_imm);
	}
	
	float return_Reg_imm()
	{	
	return Reg_imm;
	}
	boolean return_has_finished_execution()
	{
		return has_finished_execution;
	}
	
	
	boolean return_is_this_stage_completed()
	{
		return is_this_stage_completed;
	}
	boolean return_is_in_scope()
	{
		return is_in_scope;
	}
}
