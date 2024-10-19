import pygame
from pygame.locals import QUIT
from random import randint

# Cores
PRETO = (0, 0, 0)
AMARELO = (255, 255, 0)

pygame.init()

screen = pygame.display.set_mode((800, 600), 0, 32)

x_start = 200
y_start = 50
largura = 60
altura = 60
sair = False
while not sair:
    # Calcular regras

    # Denhar tela
    screen.fill( PRETO )
    for linha in range(8):
        y = y_start + (linha * altura)
        for coluna in range(8):
            x = x_start + (coluna * largura)
            if (linha + coluna) % 2 == 0:
                expessura = 3
            else:
                expessura = 0
            # valor = randint(0, 1)
            # if valor == 0:
            #     expessura = 0
            # else:
            #     expessura = 3
            pygame.draw.rect( screen, AMARELO,
                            ( (x, y), (largura, altura) ), expessura )
    pygame.display.update()
    
    # Capturar eventos
    for event in pygame.event.get():
        if event.type == QUIT:
            sair = True