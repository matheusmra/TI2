package app;

import java.util.List;
import java.util.Scanner;

// Dependencias
import dao.LocatarioDAO;
import model.Locatario;

public class Aplicacao 
{
	public static Scanner sc = new Scanner(System.in);

	public static void main( String[] args ) throws Exception 
	{
		// variaveis
		LocatarioDAO locatarioDAO = new LocatarioDAO();
		Locatario locatario = new Locatario();
 
		int opcao = 0;

		do
		{
			// mostrar o menu 
			menu( );
			
			// leitura de dados
			System.out.print( "Digite uma opcao: " );
			opcao = sc.nextInt( );
			
			switch( opcao )
			{
			case 1:
				listarLocatarios( locatarioDAO );
				break;
			case 2:
				inserirLocatario( locatarioDAO, locatario );
				break;
			case 3:
				excluirLocatario( locatarioDAO, locatario );
				break;
			case 4:
				atualizarLocatario(locatarioDAO, locatario  );
				break;
			case 5:
				System.out.printf( "\n%s\n" , "Programa encerrado." );
				break;
				
			default:
				System.out.printf( "\n%s\n" , "ERRO: Opcao Invalida" );
				break;
			} // end switch case
		}while ( opcao != 5 ); // end do while
		
		sc.close();
	} // end main ( )
	
	// menu
	public static void menu( ) 
	{
		System.out.println("\n*****MENU***** " );
		System.out.println(" 1 - Listar    " );
		System.out.println(" 2 - Inserir   " );
		System.out.println(" 3 - Excluir   " );
		System.out.println(" 4 - Atualizar " );
		System.out.println(" 5 - Sair      " );
	} // end menu ( )
	
	public static void listarLocatarios( LocatarioDAO locatarioDAO ) 
	{

		List<Locatario> locatarios;
		
		System.out.println( "\n*****LISTA*****" );
			locatarios = locatarioDAO.get();
			for (Locatario u : locatarios) 
			{
				System.out.println(u.toString());
			} // end for
	
	}
    private static void inserirLocatario( LocatarioDAO locatarioDAO, Locatario locatario ) 
    {
    	int id = 0;
    	char sexo = '0';
    	Locatario locatarioExist;
    	boolean idExist = false;
    	
        System.out.println("\n*****Inserir locatario*****");
        
        do 
        {
        	System.out.print("Digite o código: ");
        	id = sc.nextInt();
        	sc.nextLine();
        	
        	locatarioExist = locatarioDAO.get( id );
        	if( locatarioExist != null )
        	{
        		System.out.println( "ERRO: Codigo ja existe. Digite outro codigo" );
        	}
        	else
        	{
        		idExist = true;
        	} // end if
        } while( !idExist ); // end while
        
        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();
        
        System.out.print("Digite o endereço: ");
        String endereco = sc.nextLine();
        
        System.out.print("Digite o sexo (M/F): ");
        sexo = sc.next().charAt(0);
        
        locatario = new Locatario( id, nome, endereco, sexo );
        
		if ( locatarioDAO.insert(locatario) ) 
        {
            System.out.println( "Inserção com sucesso -> " + locatario.toString() );
        } else {
            System.out.println( "Falha ao inserir locatario." );
        } // end if
    } // end inserirLocatario ( )  
    
   
    private static void atualizarLocatario( LocatarioDAO locatarioDAO, Locatario locatario ) 
    {
    	int id = 0;
    	
        System.out.println("\n*****Atualizar locatario*****");
        
        System.out.print("Informe o id do locatario a ser atualizado: ");
        id = sc.nextInt();
        sc.nextLine();
        
        locatario = locatarioDAO.get(id);
        if (locatario != null) 
        {
            System.out.print("Informe o novo nome: ");
            locatario.setNome(sc.nextLine());
            
            System.out.print("Informe a novo endereco: ");
            locatario.setEndereco(sc.nextLine());
            
            System.out.print("Informe o novo sexo (M/F): ");
            locatario.setSexo(sc.next().charAt(0));
            
            if (locatarioDAO.update(locatario)) 
            {
                System.out.println("Locatario atualizado com sucesso.");
            } else {
                System.out.println("Falha ao atualizar locatario.");
            } // end if
        } else 
        {
            System.out.println("Locatario não encontrado.");
        } // end if
    } // end atualizarLocatario ( )
    
    private static void excluirLocatario( LocatarioDAO locatarioDAO, Locatario locatario ) 
    {
        int id = 0;
    	char confirmar = '0';
    	
    	System.out.println("\n*****Excluir locatario*****");
        
        System.out.print("Informe o id do locatario a ser excluído: ");
        id = sc.nextInt();
        
        System.out.println( "Tem certeza que deseja excluir o locatario? (S/N): " );
        confirmar = sc.next().charAt( 0 );
        
        if( confirmar == 'S' || confirmar == 's' )
        {
        	if ( locatarioDAO.delete(id) ) 
        	{
        		System.out.println("Locatario excluído com sucesso.");
        	} else 
        	{
        		System.out.println("Falha ao excluir locatario.");
        	} // end if
        }
        else if( confirmar == 'N' || confirmar == 'n' )
        {
        	System.out.println( "\nExclusao cancelada." );
        }
        else
        {
        	System.out.println( "\nERRO: Opcao invalida" );
        } // end if
        
    } // end excluirLocatario ( )
	
} // end class