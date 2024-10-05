package dev.sebaspuruguay.pc1dam20100786tenipuclla

import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import dev.sebaspuruguay.pc1dam20100786tenipuclla.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa el Navigation Drawer
        drawerLayout = findViewById(R.id.drawer_layout)

        // Configura el Navigation Drawer
        setupNavigationDrawer()

        // Cargar el Fragment inicial (opcional)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ListadoFragment()) // Puedes iniciar con un Fragment por defecto
                .commit()
        }
    }

    private fun setupNavigationDrawer() {
        val navView: NavigationView = findViewById(R.id.nav_view)

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_listado -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ListadoFragment())
                        .commit()
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_rendimiento -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, RendimientoFragment())
                        .commit()
                    drawerLayout.closeDrawers()
                    true
                }
                else -> {
                    Toast.makeText(this, "Credenciales inválidas", Toast.LENGTH_SHORT).show()
                    false
                }
            }
        }
    }