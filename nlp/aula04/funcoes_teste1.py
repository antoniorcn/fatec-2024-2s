"""
    Teste de funções
"""
a1 = { 'ra': '000001',  'nome': 'Joao Silva', 'telefone': '(11) 1111-1111',
       'nascimento': '05/04/2000', 'notas': [5.0, 7.0, 8.5, 6.5],
       'ano de ingresso': 2017 }
a2 = { 'ra': '000002', 'nome': 'Maria Silva',
       'telefone': '(11) 2222-2222', 'nascimento': '03/02/1989',
       'notas': [7.5, 8.5, 9.2, 6,3], 'ano de ingresso': 2016 }


def imprimir_dados( aluno : dict ):
    """
        Função que imprime dados de alunos
        é preciso passar um dicionario de aluno
    """
    w = 10
    aluno['ra'] = "XXXXXX"
    aluno['notas'] = [0, 0, 0, 0]
    aluno['ano de ingresso'] = "Não informado"
    print("-" * 60)
    print( "RA: ", aluno['ra'] )
    print( "Nome: ", aluno['nome'] )
    print( "Telefone: ", aluno['telefone'] )
    if 'notas' in aluno:
        print( "Notas:", aluno['notas'])
    if 'ano de ingresso':
        print( "Ano de ingresso: ", aluno['ano de ingresso'])

c1 = {'nome': 'Alberto Campos',
      'telefone': '(11) 3333-3333', 
      'nome empresa': 'XYZ'}

a4 = {'ra': '00004'}

print("A1: ", a1)
print("A2: ", a2)
print("C1: ", c1)

imprimir_dados( a1 )
imprimir_dados( a2 )
imprimir_dados( c1 )

print("A1: ", a1)
print("A2: ", a2)
print("C1: ", c1)
