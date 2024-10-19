import pygame
from pygame.locals import QUIT
# Valor 1 - Jogador 1      2 - Jogador 2      0 - Vazio
matriz = [
# colunas    0  1  2
            [0, 0, 0],      # linha 0
            [0, 0, 0],      # linha 1
            [0, 0, 0]       # linha 2
]

pygame.init()

screen = pygame.display.set_mode( (800, 600), 0, 32 )

largura = 200
altura = 150
inicio_x = 100
inicio_y = 100

sair = False
while not sair:
    # Calcular as regras

    # Mostrar na tela
    screen.fill( (0, 0, 0) )        # Limpar a tela
    for linha in range(3):
        y = inicio_y + (linha * altura)
        for coluna in range(3):
            x = inicio_x + (coluna * largura)
            pygame.draw.rect(screen, (255, 255, 0),
                            ( (x, y), (largura, altura) ), 3  )

    pygame.display.update()         # Atualiza a tela

    # Capturar os eventos
    for event in pygame.event.get():
        if event.type == QUIT:
            sair = True