package com.example.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<LanguageData>()
    private lateinit var adapter: LanguageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = LanguageAdapter(mList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

    }

    private fun filterList(query: String?) {
        if (query != null){
            val filteredList = ArrayList<LanguageData>()
            for (i in mList){
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }
            if (filteredList.isEmpty()){
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }


    private fun addDataToList() {
        mList.add(
            LanguageData(
                "Java",
                R.drawable.java,
                "Java is a widely-used programming language for coding web applications. It has been a popular choice among developers for over two decades, with millions of Java applications in use today."
            )
        )
        mList.add(
            LanguageData(
                "Kotlin",
                R.drawable.kotlin,
                "Kotlin is an open-source, statically-typed programming language that supports both object-oriented and functional programming. Kotlin provides similar syntax and concepts from other languages, including C#, Java, and Scala, among many others."
            )
        )
        mList.add(
            LanguageData(
                "C++",
                R.drawable.cplus,
                "C++ is an object-oriented programming (OOP) language that is viewed by many as the best language for creating large-scale applications. C++ is a superset of the C language. A related programming language, Java, is based on C++ but optimized for the distribution of program objects in a network such as the Internet."
            )
        )
        mList.add(
            LanguageData(
                "Python",
                R.drawable.python,
                "Python is an interpreted, interactive, object-oriented programming language. It incorporates modules, exceptions, dynamic typing, very high level dynamic data types, and classes. It supports multiple programming paradigms beyond object-oriented programming, such as procedural and functional programming."
            )
        )
        mList.add(
            LanguageData(
                "Ruby",
                R.drawable.ruby,
                "More specifically, Ruby is a scripting language designed for front- and back-end web development, as well as other similar applications. It's a robust, dynamically typed, object-oriented language, with high-level syntax that makes programming with it feel almost like coding in English."
            )
        )
        mList.add(
            LanguageData(
                "C",
                R.drawable.c,
                "C is a general-purpose programming language created by Dennis Ritchie at the Bell Laboratories in 1972. It is a very popular language, despite being old. C is strongly associated with UNIX, as it was developed to write the UNIX operating system."
            )
        )
        mList.add(
            LanguageData(
                "C#",
                R.drawable.csharp,
                "C# (pronounced \"See Sharp\") is a modern, object-oriented, and type-safe programming language. C# enables developers to build many types of secure and robust applications that run in .NET. C# has its roots in the C family of languages and will be immediately familiar to C, C++, Java, and JavaScript programmers."
            )
        )
        mList.add(
            LanguageData(
                "JavaScript",
                R.drawable.javascript,
                "JavaScript (JS) is a lightweight, interpreted, or just-in-time compiled programming language with first-class functions. While it is most well-known as the scripting language for Web pages, many non-browser environments also use it, such as Node.js, Apache CouchDB and Adobe Acrobat."
            )
        )
    }
}