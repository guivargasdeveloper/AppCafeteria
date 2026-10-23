import java.awt.CardLayout
import java.awt.Component
import java.awt.Dimension
import java.awt.Font
import javax.swing.BorderFactory
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JComboBox
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JSpinner
import javax.swing.JTextField
import javax.swing.SpinnerNumberModel
import javax.swing.SwingUtilities

fun main() {
    SwingUtilities.invokeLater {
        val frame = JFrame("Cafeteria Dev - Sistema de Pedidos")
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.size = Dimension(420, 480)
        frame.setLocationRelativeTo(null) // Centraliza a janela na tela

        val cardLayout = CardLayout()
        val mainPanel = JPanel(cardLayout)

        val telaPedido = JPanel()
        telaPedido.layout = BoxLayout(telaPedido, BoxLayout.Y_AXIS)
        telaPedido.border = BorderFactory.createEmptyBorder(20, 20, 20, 20)

        val lblTitulo1 = JLabel("☕ Faça seu Pedido")
        lblTitulo1.font = Font("Arial", Font.BOLD, 20)
        lblTitulo1.alignmentX = Component.LEFT_ALIGNMENT

        val lblNome = JLabel("Seu Nome:")
        lblNome.alignmentX = Component.LEFT_ALIGNMENT
        val txtNome = JTextField(15)
        txtNome.maximumSize = Dimension(Int.MAX_VALUE, 32)
        txtNome.alignmentX = Component.LEFT_ALIGNMENT

        val lblCafe = JLabel("Escolha a Bebida:")
        lblCafe.alignmentX = Component.LEFT_ALIGNMENT
        val comboCafe = JComboBox(
            arrayOf(
                "Café Expresso - R$ 6,00",
                "Cappuccino - R$ 10,00",
                "Café Gelado - R$ 12,00"
            )
        )
        comboCafe.maximumSize = Dimension(Int.MAX_VALUE, 32)
        comboCafe.alignmentX = Component.LEFT_ALIGNMENT

        val lblQtd = JLabel("Quantidade:")
        lblQtd.alignmentX = Component.LEFT_ALIGNMENT
        val spinnerQtd = JSpinner(SpinnerNumberModel(1, 1, 20, 1))
        spinnerQtd.maximumSize = Dimension(Int.MAX_VALUE, 32)
        spinnerQtd.alignmentX = Component.LEFT_ALIGNMENT

        val btnAvancar = JButton("Ver Resumo do Pedido")
        btnAvancar.alignmentX = Component.LEFT_ALIGNMENT
        btnAvancar.font = Font("Arial", Font.BOLD, 14)
    }
}