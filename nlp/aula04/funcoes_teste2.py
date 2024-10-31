"""
    Teste de funções parte 2
"""

def somar( num1=0, num2=0 ):
    """
        Função para somar números
    """
    num1 = 100
    print("num1: ", num1)
    print("num2: ", num2)
    resultado = num1 + num2
    return resultado, num1, num2


def somar_tipada( num1 : int, num2 : int ) -> int:
    """
        Função para somar números
    """
    resultado = num1 + num2
    return resultado

x = 50
y = 40
s1, _, _ = somar(x, y)
print( s1 )
print("X: ", x)
print("Y: ", y)
# print( somar(10, 20) )  # 30
