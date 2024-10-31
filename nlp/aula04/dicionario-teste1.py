'''
    #        0           1
    a1 = ['000001', 'Joao Silva', 
    #        2                  3                 4
        '(11) 1111-1111', '111.111.111-11', '05/04/2000']
    a1[4]
'''

#       chave:  valor      chave:  valor        chave:      valor 
a1 = {   'ra': '000001',  'nome': 'Joao Silva', 'telefone': '(11) 1111-1111',
#       chave:        valor         chave: valor
        'nascimento': '05/04/2000', 'notas': [5.0, 7.0, 8.5, 6.5],
        'ano de ingresso': 2017 }

a2 = {'ra': '000002', 'nome': 'Maria Silva', 
      'telefone': '(11) 2222-2222', 'nascimento': '03/02/1989',
      'notas': [7.5, 8.5, 9.2, 6,3], 'ano de ingresso': 2016}

print( "RA: ", a1['ra'] )
print( "Telefone: ", a1['telefone'] )
print( "Notas:", a1['notas'])
print( "Ano de ingresso: ", a1['ano de ingresso'])

print( "RA: ", a2['ra'] )
print( "Telefone: ", a2['telefone'] )
print( "Notas:", a2['notas'])
print( "Ano de ingresso: ", a2['ano de ingresso'])

